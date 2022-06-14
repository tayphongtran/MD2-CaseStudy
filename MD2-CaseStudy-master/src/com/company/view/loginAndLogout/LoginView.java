package com.company.view.loginAndLogout;

import com.company.controller.UserController;
import com.company.dto.SignUpDTO;
import com.company.view.Main;

import java.util.Scanner;

public class LoginView {
    Scanner scanner = new Scanner(System.in);
    UserController userController = new UserController();

    public LoginView() {
        System.out.println("login form ");
        System.out.println("enter your username: ");
        String username = scanner.nextLine();
        System.out.println("enter your password: ");
        String password = scanner.nextLine();
        SignUpDTO signUpDTO = new SignUpDTO(username, password);

        if (userController.login(signUpDTO)) {
            new ProfileView();
        } else {
            System.err.println("Login Failed! ");
           new Main();
        }
    }
}
