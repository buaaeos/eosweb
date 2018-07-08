package buaa.eos.service;
import buaa.eos.mapper.ActionDataMapper;
import buaa.eos.model.ActionData;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ActionDataService {
    @Autowired
    private ActionDataMapper actionDataMapper;


    public int save(List<ActionData> actionDataList) {
        int feedback = 0;

        feedback = actionDataMapper.insertList(actionDataList);

        return feedback;
    }

}

