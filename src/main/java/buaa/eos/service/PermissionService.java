package buaa.eos.service;

import buaa.eos.mapper.PermissionMapper;
import buaa.eos.model.Permission;
import buaa.eos.model.Permission;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PermissionService {
    @Autowired
    private PermissionMapper permissionMapper;



    public int save(List<Permission> permissionList) {
        int feedback = 0;

        feedback = permissionMapper.insertList(permissionList);

        return feedback;
    }

}

