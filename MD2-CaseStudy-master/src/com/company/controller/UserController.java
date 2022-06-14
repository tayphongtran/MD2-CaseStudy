package com.company.controller;

import com.company.dto.SignUpDTO;
import com.company.model.Role;
import com.company.model.RoleName;
import com.company.model.User;
import com.company.model.UserPrincipal;
import com.company.service.role.RoleSeviceIMPL;
import com.company.service.user.UserServiceIMPL;
import com.company.service.user_principal.UserPrincipalServiceIMPL;

import java.util.HashSet;
import java.util.Set;

public class UserController {
    UserServiceIMPL userServiceIMPL = new UserServiceIMPL();
    RoleSeviceIMPL roleSeviceIMPL = new RoleSeviceIMPL();
    UserPrincipalServiceIMPL userPrincipalServiceIMPL = new UserPrincipalServiceIMPL();

    public void register(SignUpDTO signUpDTO){
        int id;
        if (UserServiceIMPL.userList.size()==0){
            id = 1;
        }else {
            id = UserServiceIMPL.userList.get(UserServiceIMPL.userList.size()-1).getId() +1;
        }
        Set<String> strRole = signUpDTO.getStrRole();
        Set<Role> roleSet = new HashSet<>();

        strRole.forEach(role ->{
            switch (role){
                case "admin":
                    Role adminRole = roleSeviceIMPL.findByName(RoleName.ADMIN);
                    roleSet.add(adminRole);
                    break;
                case "pm":
                    Role  pmRole = roleSeviceIMPL.findByName(RoleName.PM);
                    roleSet.add(pmRole);
                    break;
                case "user":
                    Role userRole = roleSeviceIMPL.findByName(RoleName.USER);
                    roleSet.add(userRole);
                    break;

            }
        });
        User user = new User(id,signUpDTO.getName(),signUpDTO.getUsername(),signUpDTO.getPassword(),roleSet);
        userServiceIMPL.save(user);
        userServiceIMPL.findAll();
    }

    public boolean login(SignUpDTO signUpDTO){
        if (userServiceIMPL.checkLogin(signUpDTO.getUsername(), signUpDTO.getPassword())) {
            User user = userServiceIMPL.findByUserName(signUpDTO.getUsername());
            UserPrincipal userPrincipal = new UserPrincipal(user.getId(),user.getName(),user.getUsername(),user.getPassword(),user.getRoleSet());
            userPrincipalServiceIMPL.save(userPrincipal);
            userPrincipalServiceIMPL.findAll();
            return true;
        }else {
            return false;
        }
    }

}
