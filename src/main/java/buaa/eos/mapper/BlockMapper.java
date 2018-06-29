package buaa.eos.mapper;

import buaa.eos.model.Block;
import buaa.eos.util.MyMapper;
import org.apache.ibatis.annotations.Select;
public interface BlockMapper extends MyMapper<Block> {
    @Select("select MAX(id) from block")
    Integer selectMaxBlockNum();
}