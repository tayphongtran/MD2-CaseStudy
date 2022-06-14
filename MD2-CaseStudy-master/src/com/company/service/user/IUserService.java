package com.company.service.user;

import com.company.model.User;
import com.company.service.IServiceGeneric;

public interface IUserService extends IServiceGeneric<User> {
    User findByUserName(String username);
    boolean checkLogin(String username, String password);
    boolean existedByUserName(String username);
    boolean existedByPassWord(String passWord);
}
