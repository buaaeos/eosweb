package buaa.eos.service;

import buaa.eos.mapper.VoteInfoMapper;
import buaa.eos.model.VoteInfo;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class VoteInfoService {
    @Autowired
    private VoteInfoMapper voteInfoMapper;



    public int save(VoteInfo voteInfo) {
        int feedback = 0;
        if (voteInfo.getId() != null) {
            feedback = voteInfoMapper.updateByPrimaryKey(voteInfo);
        } else {
            feedback = voteInfoMapper.insert(voteInfo);
        }
        return feedback;
    }

}

