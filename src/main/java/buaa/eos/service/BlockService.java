package buaa.eos.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import buaa.eos.mapper.BlockMapper;
import buaa.eos.model.Block;
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


    public void save(Block block) {
        if (block.getId() != null) {
            blockMapper.updateByPrimaryKey(block);
        } else {
            blockMapper.insert(block);
        }
    }
}
