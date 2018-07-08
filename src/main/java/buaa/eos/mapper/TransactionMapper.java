package buaa.eos.mapper;

import buaa.eos.model.Transaction;
import buaa.eos.util.MyMapper;
import org.apache.ibatis.annotations.Select;

public interface TransactionMapper extends MyMapper<Transaction> {
    @Select("select Count(*) from transaction")
    Integer countTransaction();
}