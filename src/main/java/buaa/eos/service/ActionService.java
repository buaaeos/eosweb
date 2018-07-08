package buaa.eos.service;
import buaa.eos.mapper.ActionMapper;
import buaa.eos.model.Action;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ActionService {
    @Autowired
    private ActionMapper actionMapper;



    public int save(List<Action> actionList) {
        int feedback = 0;

        feedback = actionMapper.insertList(actionList);

        return feedback;
    }

}

