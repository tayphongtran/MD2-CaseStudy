package com.company.view.loginAndLogout;

import com.company.model.Role;
import com.company.model.RoleName;
import com.company.model.UserPrincipal;
import com.company.service.user_principal.UserPrincipalServiceIMPL;
import com.company.view.Main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class ProfileView {
    List<UserPrincipal> userPrincipalList = UserPrincipalServiceIMPL.userPrincipalList;
    UserPrincipalServiceIMPL userPrincipalServiceIMPL = new UserPrincipalServiceIMPL();

    public ProfileView() {
        Scanner scanner = new Scanner(System.in);
        Set<Role> roleSet = UserPrincipalServiceIMPL.userPrincipalList.get(0).getRoleSet();
        List<Role> roleList = new ArrayList<>(roleSet);
        if (userPrincipalList.size() != 0) {
            System.out.println("Welcome to profile " + userPrincipalList.get(0).getName());
            System.out.println("1. logout");
            System.out.println("2. Back menu");
            int chooseProfile = scanner.nextInt();
            switch (chooseProfile) {
                case 1:
                    logout();
                    new Main();
                    break;
                case 2:
                    new Main();
                    break;
            }
        } else {
            System.out.println("Please Login!");
        }


//        String backMenu = scanner.nextLine();
//        if (backMenu.equalsIgnoreCase("quit")){
//            new Main();
//        }
    }

    public void logout() {
        userPrincipalList.clear();
        userPrincipalServiceIMPL.findAll();
//        new Main();
    }
}
