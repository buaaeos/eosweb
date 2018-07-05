package buaa.eos.service;
import buaa.eos.mapper.TransactionMapper;
import buaa.eos.model.Transaction;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TransactionService {
    @Autowired

    private TransactionMapper trxMapper;

    public JSONObject  parseToSimple(JSONObject jsonObject){
        Object trx = jsonObject.get("trx");
        jsonObject.remove("trx");
        JSONObject newJson = new JSONObject();
        newJson.putAll(jsonObject);
        newJson.putAll((JSONObject)trx);
        Object trx2 = newJson.get("transaction");
        newJson.remove("transaction");
        newJson.putAll((JSONObject)(trx2));
        return newJson;
    }

    public int save(Transaction trx) {
        int feedback = 0;
        if (trx.getTrx_id() != null) {
            feedback = trxMapper.updateByPrimaryKey(trx);
        } else {
            feedback = trxMapper.insert(trx);
        }
        return feedback;
    }

}
