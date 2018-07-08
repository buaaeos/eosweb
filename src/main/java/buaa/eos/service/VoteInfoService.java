package buaa.eos.service;

import buaa.eos.mapper.VoteInfoMapper;
import buaa.eos.model.VoteInfo;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class VoteInfoService {
    @Autowired
    private VoteInfoMapper voteInfoMapper;



    public int save(List<VoteInfo> voteInfoList) {
        int feedback = 0;

        feedback = voteInfoMapper.insertList(voteInfoList);

        return feedback;
    }

}

