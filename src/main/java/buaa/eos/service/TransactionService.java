package buaa.eos.service;
import buaa.eos.mapper.TransactionMapper;
import buaa.eos.model.Transaction;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class TransactionService {
    @Autowired

    private TransactionMapper trxMapper;

    public JSONObject  parseToSimple(Map<String,Object> jsonObject){
        Object trx = jsonObject.get("trx");
        jsonObject.remove("trx");
        JSONObject newJson = new JSONObject();
        newJson.putAll(jsonObject);
        newJson.putAll((JSONObject)trx);
        Object trx2 = newJson.get("transaction");
        newJson.remove("transaction");
        newJson.putAll((JSONObject)(trx2));
//        newJson.put("packed_trx","");
        return newJson;
    }

    public int save(List<Transaction> trxList) {
        int feedback = 0;
//        if (trx.getTrx_id() != null) {
//            feedback = trxMapper.updateByPrimaryKey(trx);
//        } else {
            feedback = trxMapper.insertList(trxList);
//        }
        return feedback;
    }

    public Integer transactionCount(){
        return trxMapper.countTransaction();
    }

}
