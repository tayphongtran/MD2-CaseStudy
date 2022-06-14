package com.company.view.loginAndLogout;

import com.company.service.user.UserServiceIMPL;
import com.company.view.Main;

import java.util.Scanner;

public class ListUserView {
    Scanner scanner = new Scanner(System.in);
    public ListUserView() {
        System.out.println("list user" + UserServiceIMPL.userList);
        System.out.println("Enter quit to backMenu");
        String backMenu = scanner.nextLine();
        if (backMenu.equalsIgnoreCase("quit")){


            new Main();
        }
        System.out.println("VE LIST USER");
    }
}
