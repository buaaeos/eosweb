package buaa.eos.service;

import buaa.eos.mapper.PermissionMapper;
import buaa.eos.model.Permission;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PermissionService {
    @Autowired
    private PermissionMapper permissionMapper;



    public int save(Permission permission) {
        int feedback = 0;
        if (permission.getId() != null) {
            feedback = permissionMapper.updateByPrimaryKey(permission);
        } else {
            feedback = permissionMapper.insert(permission);
        }
        return feedback;
    }

}

