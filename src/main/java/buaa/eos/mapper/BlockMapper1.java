package buaa.eos.mapper;

import buaa.eos.model.Block;
import buaa.eos.util.MyMapper;
import org.apache.ibatis.annotations.Select;

import java.util.Date;

public interface BlockMapper1 extends MyMapper<Block> {
    @Select("select MAX(block_num) from block")
    Integer selectMaxBlockNum();
    @Select("select MAX(timestamp) from block")
    Date selectMaxTimestamp();
}