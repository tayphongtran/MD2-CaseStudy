package com.company.view.loginAndLogout;

import com.company.controller.RoleController;
import com.company.view.Main;

import java.util.Scanner;

public class RoleView {
    Scanner scanner = new Scanner(System.in);
   RoleController roleController = new RoleController();

    public void showListRole(){
        System.out.println(roleController.showListRole());
        System.out.println("enter quit to back menu: ");
        String backMenu = scanner.nextLine();
        if (backMenu.equalsIgnoreCase("quit")){

            new Main();
        }
    }
}
