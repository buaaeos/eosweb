package buaa.eos.service;
import buaa.eos.mapper.ActionMapper;
import buaa.eos.model.Action;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ActionService {
    @Autowired
    private ActionMapper actionMapper;



    public int save(Action action) {
        int feedback = 0;
        if (action.getId() != null) {
            feedback = actionMapper.updateByPrimaryKey(action);
        } else {
            feedback = actionMapper.insert(action);
        }
        return feedback;
    }

}

