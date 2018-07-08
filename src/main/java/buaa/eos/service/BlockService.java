package buaa.eos.service;
import net.sf.json.JSONObject;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import buaa.eos.model.Block;
import buaa.eos.mapper.BlockMapper;

import javax.annotation.Resource;
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

    public int save(List<Block> blockList) {
        int feedback = 0;
        blockMapper.insertList(blockList);
        return feedback;


    }

}
