package com.company.view.loginAndLogout;

import com.company.controller.UserController;
import com.company.dto.SignUpDTO;
import com.company.service.role.RoleSeviceIMPL;
import com.company.service.user.UserServiceIMPL;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Pattern;

public class RegisterView {
    Scanner scanner = new Scanner(System.in);

    UserController userController = new UserController();
    UserServiceIMPL userServiceIMPL = new UserServiceIMPL();

    public RegisterView() {
        new RoleSeviceIMPL().findAll();
        System.out.println("nhap ten cua ban: ");
        String name = scanner.nextLine();
        System.out.println("tao tai khoan:");
        boolean checkUserName, checkPassWord;
        String username;
        String password = null;
        while (true) {
            username = scanner.nextLine();
            checkUserName = Pattern.matches("[a-z0-9_-]{6,}", username);
            if (!checkUserName) {
                System.out.println("UserName failed! Please try again!");
            } else if (userServiceIMPL.existedByUserName(username)) {
                System.out.println("Username  is existed! Please try again!");
            } else {
                break;
            }
        }
        System.out.println("nhap mat khau");

        String npassword = scanner.nextLine();
        checkPassWord = Pattern.matches("[A-z0-9]{6,}", npassword);
        while (!checkPassWord) {
            if (!checkPassWord) {
                System.out.println("nhap lai mat khau tu 6 kí tu tro len");
                npassword = scanner.nextLine();
                break;
            }
        }
        System.out.println("Enter your role: ");
        String role = scanner.nextLine();
        Set<String> strRole = new HashSet<>();
        strRole.add(role);
        SignUpDTO signUpDTO = new SignUpDTO(name, username, npassword, strRole);
        userController.register(signUpDTO);
        new LoginView();

    }
}