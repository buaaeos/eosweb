package buaa.eos.background;
import buaa.eos.model.*;
import buaa.eos.service.*;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.*;

@Component
@EnableScheduling
public class Blockinfo {
    @Autowired
    private BlockService blockService;
    @Autowired
    private TransactionService trxService;

    @Autowired
    private ActionService actionService;
    @Autowired
    private ActionDataService actionDataService;
    @Autowired
    private AccountService accountService;
    @Autowired
    private PermissionService permissionService;
    @Autowired
    private VoteInfoService voteInfoService;

    private int i = 1;

    @Scheduled(fixedDelay = 5000)        //fixedDelay = 5000表示当方法执行完毕5000ms后，Spring scheduling会再次调用该方法
    public void updateBlock() throws Exception {

        Integer localBlockNum = 1;
        Integer RemoteBlockNum = 0;
        localBlockNum = blockService.getMaxBlockId();
        if (localBlockNum == null) {
            localBlockNum = 1;
        }
        RemoteBlockNum = HttpUtil.getEosBlockNum();
        while (localBlockNum < RemoteBlockNum) {
            System.out.println("local:"+localBlockNum.toString());
            System.out.println("Remote:"+RemoteBlockNum.toString());

            String para = "{\"block_num_or_id\":\""+localBlockNum.toString()+"\"}";
            String method = "get_block";
            String jsondata = HttpUtil.doEosPost(method, para);
            Block block = new Block();

            if(jsondata == null)
            {
                block.setBlock_num(localBlockNum);
                Date date = new Date();
                block.setTimestamp(date.toString());
                block.setId("error");
            }
            else
            {

                block = (Block) CommonService.autoSetAttr(jsondata,block);
                blockService.save(block);

                /*save transactions*/
                Transaction trx = new Transaction();
                trx.setBlock_num(block.getBlock_num());
                String trxJson = block.getTransactions();
                if(!trxJson.equals("[]")){
                    JSONArray jsonArray = JSONArray.fromObject(trxJson);
                    for(Object obj:jsonArray) {
                        JSONObject jsonObject = trxService.parseToSimple((JSONObject) obj);
                        trx = (Transaction) CommonService.autoSetAttr(jsonObject, trx);
                        trxService.save(trx);
                        int trxId = trx.getTrx_id();

                        /*save actions*/
                        Action action = new Action();
                        action.setTrx_id(trxId);
                        Object actionJson = jsonObject.get("actions");
                        JSONArray actionArray = JSONArray.fromObject(actionJson);
                        for(Object act:actionArray) {
                            JSONObject actionObj = JSONObject.fromObject(act);
                            action = (Action) CommonService.autoSetAttr(actionObj, action);
                            actionService.save(action);
                            int actionId = action.getId();

                            /*save action data*/
                            if(actionObj.get("name").equals("transfer")) {
                                ActionData actionData = new ActionData();
                                actionData.setAction_id(actionId);
                                JSONObject actionDataObj = JSONObject.fromObject(actionObj.get("data"));
                                actionDataObj.put("from_",actionDataObj.get("from"));
                                actionDataObj.remove("from");
                                actionDataObj.put("to_",actionDataObj.get("to"));
                                actionDataObj.remove("to");
                                actionData = (ActionData) CommonService.autoSetAttr(actionDataObj, actionData);
                                actionDataService.save(actionData);

//                                accounts.add(action.getAccount());
//                                accounts.add(actionData.getFrom_());
//                                accounts.add(actionData.getTo_());
//                                updateAccount(accounts);
                            }
                        }
                    }
                }



            }
            localBlockNum =localBlockNum+1;
//            localBlockNum = (Integer) jsonObject.get("block_num") + 1;
            RemoteBlockNum = HttpUtil.getEosBlockNum();

        }
        System.out.printf("第 %d 次迭代成功\n", i++);
    }

    public void updateAccount(Set<String> accounts) throws Exception{
        String method = "get_account";

        for (String accountName: accounts) {
            Account account = new Account();
            String para = "{\"account_name\":\""+accountName+"\"}";
            String jsonData = HttpUtil.doEosPost(method, para);
            if(jsonData != null){
                JSONObject accountObject = JSONObject.fromObject(jsonData);
                account = (Account) CommonService.autoSetAttr(accountObject, account);
                int feed = accountService.save(account);
                int accountId = account.getId();
                if(feed == 1) {
                    JSONArray permissions = JSONArray.fromObject(accountObject.get("permissions"));
                    for (Object perm : permissions) {
                        Permission permission = new Permission();
                        permission.setAccount_id(accountId);
                        JSONObject permObj = JSONObject.fromObject(perm);
                        permission = (Permission) CommonService.autoSetAttr(permObj, permission);
                        permissionService.save(permission);
                    }

                    JSONObject voteInfoObject = JSONObject.fromObject(accountObject.get("voter_info"));
                    if (voteInfoObject.size() > 0) {
                        VoteInfo voteInfo = new VoteInfo();
                        voteInfo.setId(accountId);
                        voteInfo = (VoteInfo) CommonService.autoSetAttr(voteInfoObject, voteInfo);
                        voteInfoService.save(voteInfo);
                    }
                }
            }
        }

    }
}