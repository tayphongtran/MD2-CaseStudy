package com.company.service.role;

import com.company.config.ConfigReadAndWirte;
import com.company.model.Role;
import com.company.model.RoleName;

import java.util.List;

public class RoleSeviceIMPL implements  IRoleService{
public static String PATH_ROLE = ConfigReadAndWirte.PATH + "role.txt";
public static List<Role> roleList = new ConfigReadAndWirte<Role>().readFromFile(PATH_ROLE);
    @Override
    public List<Role> findAll() {
        if (roleList.size()>=3){
            return roleList;
        }else {
            roleList.add(new Role(1,RoleName.USER));
            roleList.add(new Role(2,RoleName.PM));
            roleList.add(new Role(3,RoleName.ADMIN));
        }
        new ConfigReadAndWirte<Role>().writeToFile(PATH_ROLE,roleList);
        return roleList;
    }

    @Override
    public void save(Role role) {
        roleList.add(role);
    }

    @Override
    public Role findByName(RoleName name) {
        for (int i = 0; i < roleList.size(); i++) {
            if (name == roleList.get(i).getName()){
                return roleList.get(i);
            }
        }

        return null;
    }
}
