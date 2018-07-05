package buaa.eos.service;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import buaa.eos.model.Block;
import buaa.eos.mapper.BlockMapper;

import java.util.*;

@Service
public class BlockService {
    @Autowired

    private BlockMapper blockMapper;
    public Block getById(Integer id){

        return blockMapper.selectByPrimaryKey(id);
    }


    public Integer getMaxBlockId(){
       return blockMapper.selectMaxBlockNum();
    }

    public Date getMaxTimestamp(){
        return blockMapper.selectMaxTimestamp();
    }

    public void save(Block block) {
        if (block.getBlk_id() != null) {
            blockMapper.updateByPrimaryKey(block);
        } else {
            blockMapper.insert(block);
        }
    }

}
