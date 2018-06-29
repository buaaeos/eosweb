package buaa.eos.background;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import buaa.eos.service.BlockService;
import org.json.*;
import buaa.eos.model.Block;
@Component
//@EnableScheduling
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
            String para = "{\"block_num_or_id\":\""+1+"\"}";
            String method = "get_block";
            String block = HttpUtil.doEosPost(method, para);
            JSONObject jsonObject = new JSONObject(block);
            Block model = new Block();
            model.setId((Integer) jsonObject.get("block_num"));
            model.setTimestamp((String) jsonObject.get("timestamp"));
            blockService.save(model);
            localBlockNum = (Integer) jsonObject.get("block_num") + 1;
            RemoteBlockNum = HttpUtil.getEosBlockNum();

        }
        System.out.printf("第 %d 次迭代成功\n", i++);
    }
}