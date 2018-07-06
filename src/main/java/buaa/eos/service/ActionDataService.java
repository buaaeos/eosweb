package buaa.eos.service;
import buaa.eos.mapper.ActionDataMapper;
import buaa.eos.mapper.ActionMapper;
import buaa.eos.model.Action;
import buaa.eos.model.ActionData;
import buaa.eos.model.Transaction;
import com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException;

import org.apache.commons.lang.StringEscapeUtils;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ActionDataService {
    @Autowired
    private ActionDataMapper actionDataMapper;


    public int save(ActionData actionData){
        int feedback = 0;
        if (actionData.getId() != null) {
            feedback = actionDataMapper.updateByPrimaryKey(actionData);
        } else {
            try {
                feedback = actionDataMapper.insert(actionData);
            }catch (Exception mye){
                actionData.setMemo(StringEscapeUtils.escapeSql(actionData.getMemo()));
                actionDataMapper.insert(actionData);
            }
        }
        return feedback;
    }

}

