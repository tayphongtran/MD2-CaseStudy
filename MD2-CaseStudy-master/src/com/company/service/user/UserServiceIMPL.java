package com.company.service.user;

import com.company.config.ConfigReadAndWirte;
import com.company.model.User;

import java.util.List;

public class UserServiceIMPL implements IUserService{
    public static String PATH_USER = ConfigReadAndWirte.PATH + "user.txt";
    public  static List<User> userList = new ConfigReadAndWirte<User>().readFromFile(PATH_USER);
    @Override
    public List<User> findAll() {
        new ConfigReadAndWirte<User>().writeToFile(PATH_USER,userList);
        return userList;
    }

    @Override
    public void save(User user) {
        userList.add(user);
    }

    @Override
    public User findByUserName(String username) {
        for (int i = 0; i < userList.size(); i++) {
            if (username.equals(userList.get(i).getUsername())){
                return userList.get(i);
            }
        }
        return null;
    }

    @Override
    public boolean checkLogin(String username, String password) {
        for (int i = 0; i < userList.size(); i++) {
            if (username.equals(userList.get(i).getUsername())&&password.equals(userList.get(i).getPassword())){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean existedByUserName(String username) {
        for (int i = 0; i < userList.size(); i++) {
            if (username.equals(userList.get(i).getUsername())){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean existedByPassWord(String passWord) {
        for (int i = 0; i < userList.size(); i++) {
            if (passWord.equals(userList.get(i).getPassword())){
                return true;
            }
        }
        return false;
    }
}
