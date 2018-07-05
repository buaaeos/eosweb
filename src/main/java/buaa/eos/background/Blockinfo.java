package buaa.eos.background;
import buaa.eos.model.Transaction;
import buaa.eos.service.CommonService;
import buaa.eos.service.TransactionService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import buaa.eos.service.BlockService;
import org.springframework.scheduling.annotation.EnableScheduling;
import buaa.eos.model.Block;

import java.util.Date;

@Component
@EnableScheduling
public class Blockinfo {
    @Autowired
    private BlockService blockService;
    @Autowired
    private TransactionService trxService;
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
//                blockService.save(block);

                Transaction trx = new Transaction();
                trx.setBlock_num(block.getBlock_num());
                String trxJson = block.getTransactions();
                if(!trxJson.equals("[]")){
                    JSONArray jsonArray = JSONArray.fromObject(trxJson);
                    for(Object obj:jsonArray) {
                        JSONObject jsonObject = trxService.parseToSimple((JSONObject) obj);
                        trx = (Transaction) CommonService.autoSetAttr(jsonObject, trx);
                        int trx_id = trxService.save(trx);
                        System.out.println(trx_id);
                    }
                }


            }
            localBlockNum =localBlockNum+1;
//            localBlockNum = (Integer) jsonObject.get("block_num") + 1;
            RemoteBlockNum = HttpUtil.getEosBlockNum();

        }
        System.out.printf("第 %d 次迭代成功\n", i++);
    }
}