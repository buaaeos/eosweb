package buaa.eos.background;
import buaa.eos.model.*;
import buaa.eos.service.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mysql.jdbc.MysqlDataTruncation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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
    private List<Block> blockList = new ArrayList<>();
    private List<Transaction> trxList = new ArrayList<>();
    List<Action> actionList = new ArrayList<>();
    List<ActionData> actionDataList = new ArrayList<>();
    List<Account> accountList = new ArrayList<>();
    List<Permission> permissionList = new ArrayList<>();
    List<VoteInfo> voteInfoList = new ArrayList<>();
    private ObjectMapper mapper = new ObjectMapper();
    Integer batchNum = 1000;
    @Scheduled(fixedDelay = 5000)        //fixedDelay = 5000表示当方法执行完毕5000ms后，Spring scheduling会再次调用该方法
    public void updateBlock() throws Exception {

        Integer localBlockNum = 1;
        Integer RemoteBlockNum = 0;

        localBlockNum = blockService.getMaxBlockId();
        if (localBlockNum == null) {
            localBlockNum = 1;
        }else{
            localBlockNum += 1;
        }

        RemoteBlockNum = HttpUtil.getEosBlockNum();
        Boolean saveSuccess = false;
        while (localBlockNum < RemoteBlockNum) {
            System.out.println("local:"+localBlockNum.toString());
            System.out.println("Remote:"+RemoteBlockNum.toString());

            String para = "{\"block_num_or_id\":\""+localBlockNum.toString()+"\"}";
            String method = "get_block";
            String jsondata = HttpUtil.doEosPost(method, para);

            Map blockMap = mapper.readValue(jsondata,Map.class);
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

                block = (Block) CommonService.autoSetAttr(blockMap,block);
                blockList.add(block);

                if(blockList.size()>batchNum && saveSuccess) {
                    long startTime = System.currentTimeMillis();
                    blockService.save(blockList);
                    long endTime = System.currentTimeMillis();
                    System.out.println("insert"+batchNum+" blocks with "+(endTime-startTime)+" ms");
                    blockList.clear();

                }

                /*save transactions*/
                Transaction trx = new Transaction();
                trx.setBlock_num(block.getBlock_num());
                List<Map> transactions = (List) blockMap.get("transactions");
                if(transactions.size()>0){
                    for(Map tm:transactions) {

                        Map trxMap = (Map)tm.get("trx");
                        tm.remove("trx");
                        trx = (Transaction) CommonService.autoSetAttr(tm, trx);
                        Map transMap = (Map) trxMap.get("transaction");
                        trxMap.remove("transaction");
                        trx = (Transaction) CommonService.autoSetAttr(trxMap, trx);
                        trx = (Transaction) CommonService.autoSetAttr(transMap, trx);
                        trxList.add(trx);


                        String trxId = trx.getId();

                        /*save actions*/
                        Action action = new Action();
                        action.setTrx_id(trxId);
                        List<Map> actionMap = (List) transMap.get("actions");

                        for(Map act:actionMap) {
                            action = (Action) CommonService.autoSetAttr(act, action);
                            actionList.add(action);

                            /*save action data*/
                            Object actD = act.get("data");
                            if(actD instanceof Map) {
                                Map actionDataMap = (Map)actD;
                                if (act.get("name").equals("transfer")) {
                                    ActionData actionData = new ActionData();
                                    actionData.setTrx_id(trxId);


                                    actionDataMap.put("from_", actionDataMap.get("from"));
                                    actionDataMap.remove("from");
                                    actionDataMap.put("to_", actionDataMap.get("to"));
                                    actionDataMap.remove("to");
                                    actionData = (ActionData) CommonService.autoSetAttr(actionDataMap, actionData);

                                    actionDataList.add(actionData);

                                } else if (act.get("name").equals("newaccount")) {
                                    updateAccount((String) actionDataMap.get("name"));
                                }
                            }
                        }
                        if(blockList.size()>batchNum) {
                            try {
                                trxService.save(trxList);
                                trxList.clear();
//                            for (Action ac:actionList
//                                 ) {
//                                try {
//                                    actionService.saveOne(ac);
//                                }catch (DataIntegrityViolationException e){
//
//                                    System.out.println(e.getMessage()+"\n"+ac.getTrx_id());
//                                    System.exit(-1);
//                                }
//                            }
                                actionService.save(actionList);
                                actionList.clear();

                                actionDataService.save(actionDataList);
                                actionDataList.clear();
                                saveSuccess = true;
                            }catch (Exception e){
                                System.out.println(e.fillInStackTrace());
                                System.exit(-1);
                            }

                        }
                    }
                }
//                System.exit(0);
            }

            localBlockNum =localBlockNum+1;
//            localBlockNum = (Integer) jsonObject.get("block_num") + 1;
            RemoteBlockNum = HttpUtil.getEosBlockNum();

        }
        System.out.printf("第 %d 次迭代成功\n", i++);
    }

    private void updateAccount(String accountName) throws Exception{
        String method = "get_account";
        Account account = new Account();
        String para = "{\"account_name\":\""+accountName+"\"}";
        String accountData = HttpUtil.doEosPost(method, para);
        if(accountData != null){
            Map accountMap = mapper.readValue(accountData,Map.class);


            account = (Account) CommonService.autoSetAttr(accountMap, account);
            accountList.add(account);
            if(accountList.size()>batchNum){
                int feed = accountService.save(accountList);
                accountList.clear();
            }

            String accountId = account.getAccount_name();

            List<Map> permissions = (List<Map>) accountMap.get("permissions");
            for (Map perm : permissions) {
                Permission permission = new Permission();
                permission.setAccount_name(accountName);
                permission = (Permission) CommonService.autoSetAttr(perm, permission);
                permissionList.add(permission);
                if(permissionList.size()>batchNum){
                    permissionService.save(permissionList);
                    permissionList.clear();
                }

            }

            Map voteMap = (Map) accountMap.get("voter_info");
            if (voteMap != null) {
                VoteInfo voteInfo = new VoteInfo();
//                    voteInfo.setOwnerId();
                voteInfo = (VoteInfo) CommonService.autoSetAttr(voteMap, voteInfo);
                voteInfoList.add(voteInfo);
                if(voteInfoList.size()>batchNum){
                    voteInfoService.save(voteInfoList);
                    voteInfoList.clear();
                }

            }

        }


    }
}