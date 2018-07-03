package buaa.eos.background;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import buaa.eos.service.BlockService;
import org.springframework.scheduling.annotation.EnableScheduling;
import buaa.eos.model.Block;
import net.sf.json.JSONObject;
import java.util.Date;
@Component
@EnableScheduling
public class Blockinfo {
    @Autowired
    private BlockService blockService;
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
                block.setTimestamp(date);
                block.setId("error");
            }
            else
            {
                JSONObject jsonObject =JSONObject.fromObject(jsondata);
                block = (Block) JSONObject.toBean(jsonObject,Block.class);
            }




            blockService.save(block);
            localBlockNum =localBlockNum+1;
//            localBlockNum = (Integer) jsonObject.get("block_num") + 1;
            RemoteBlockNum = HttpUtil.getEosBlockNum();

        }
        System.out.printf("第 %d 次迭代成功\n", i++);
    }
}