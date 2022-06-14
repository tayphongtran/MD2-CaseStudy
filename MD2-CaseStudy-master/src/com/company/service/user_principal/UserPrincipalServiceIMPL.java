package com.company.service.user_principal;

import com.company.config.ConfigReadAndWirte;
import com.company.model.User;
import com.company.model.UserPrincipal;
import com.company.service.user.UserServiceIMPL;

import java.util.List;

public class UserPrincipalServiceIMPL implements IUserPrincipal {

    public static String PATH_USER_PRINCIPAL = ConfigReadAndWirte.PATH + "user_principal.txt";
    public static List<UserPrincipal> userPrincipalList = new ConfigReadAndWirte<UserPrincipal>().readFromFile(PATH_USER_PRINCIPAL);

    @Override
    public List<UserPrincipal> findAll() {
        new ConfigReadAndWirte<UserPrincipal>().writeToFile(PATH_USER_PRINCIPAL, userPrincipalList);
        return userPrincipalList;
    }

    @Override
    public void save(UserPrincipal userPrincipal) {
        userPrincipalList.add(userPrincipal);
    }

    @Override
    public User getCurrentUser() {
        if (userPrincipalList.size() != 0) {
            User user = new UserServiceIMPL().findByUserName(userPrincipalList.get(0).getUsername());
            return user;
        }
        return null;
    }
}
