package com.company.view;

import com.company.model.Role;
import com.company.model.RoleName;
import com.company.model.User;
import com.company.service.user_principal.UserPrincipalServiceIMPL;
import com.company.view.loginAndLogout.*;
import com.company.view.product.CategoryView;
import com.company.view.product.ProductView;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main {
    Scanner scanner = new Scanner(System.in);

    public Main() {
        if (UserPrincipalServiceIMPL.userPrincipalList.size() == 0) {
            System.out.println("--------------------------Quản lý sản phẩm--------------------------");
            System.out.println("                         Chưa có đăng nhập!");
            System.out.println("                    1. Đăng kí \t 2. Đăng Nhập");
            int pick = scanner.nextInt();
            switch (pick) {
                case 1:
                    new RegisterView();
                    break;
                case 2:
                    new LoginView();
                    break;
            }
        } else {
            Set<Role> roleSet = UserPrincipalServiceIMPL.userPrincipalList.get(0).getRoleSet();
            List<Role> roleList = new ArrayList<>(roleSet);
            int numberAdm, user;
            if (roleList.get(0).getName() == RoleName.ADMIN) {
                System.out.println(" Welcome Admin: " + UserPrincipalServiceIMPL.userPrincipalList.get(0).getName());
                System.out.println("1: Profile");
                System.out.println("2: Show Role");
                System.out.println("3: Show List User");
                System.out.println("4: Creat Category");
                System.out.println("5: Show List Category");
                System.out.println("6: Edit Category");
                System.out.println("7: Find Category By Id");
                System.out.println("8: Delete Category By Id");
                System.out.println("9: Add a new product");
                System.out.println("10: Show list product");
                System.out.println("11: Find product by id");
                System.out.println("12: Edit show list product by id ");
                System.out.println("13: Delete product by id  ");
                System.out.println("14: Nhập id để hiển thị danh sách sản phẩm");
                System.out.println("15: Nhập tên sản phẩm muốn tìm");
                System.out.println("16: Sắp xếp theo giá ");
                System.out.println("17: Thoát");
                numberAdm = scanner.nextInt();
                switch (numberAdm) {
                    case 1:
                        new ProfileView();
                        break;
                    case 2:
                        new RoleView().showListRole();
                        break;
                    case 3:
                        new ListUserView();
                        break;
                    case 4:
                        System.out.println("creat category");
                        new CategoryView().creatCategoryView();
                        break;
                    case 5:
                        System.out.println("show list category");
                        new CategoryView().showListCategory();
                        break;
                    case 6:
//                        System.out.println("edit category");
                        new CategoryView().ediCategory();
                        break;
                    case 7:
//                        System.out.println("tim thay id san pham: " + CategoryServiceIMPL.categoryList);
                        new CategoryView().findById();
                        break;
                    case 8:
                        new CategoryView().deletedByidCategory();
                        break;
                    case 9:
                        new ProductView().creatProduct();
                        break;
                    case 10:
                        new ProductView().showListProduct();
                        break;
                    case 11:
                        new ProductView().findByIdProduct();
                        break;
                    case 12:
                        new ProductView().editByIdProduct();
                        break;
                    case 13:
                        new ProductView().deleteByIdProduct();
                        break;
                    case 14:
//                        System.out.println("nhap id Category va show ra list product theo id");
                        new CategoryView().findByIdProduct();
                        break;
                    case 15:
                        new CategoryView().findByNameCategory();
                        break;
                    case 16:
                        System.out.println("tim theo gia");
                        new ProductView().sapXepPrice();
                        break;
                    case 17:
                        System.out.println("thoát");
                        System.exit(3);
                    default:
                        System.err.println("ĐỪNG NHẬP SỐ NÀY");
                        new Main();
                        break;
                }
            } else {
                System.out.println(" welcome  user : " + UserPrincipalServiceIMPL.userPrincipalList.get(0).getName());
                System.out.println("11: profile");
                System.out.println("22: Về trang chủ");
                System.out.println("32: creat category");
                System.out.println("33: show list Category");
                System.out.println("34: tim the loai theo id ");
                System.out.println("35: show list product");
                System.out.println("36: creat product");
                System.out.println("37: tim product theo id");
                System.out.println("38: sua san pham");
                System.out.println("39: sua danh muc san pham");
                System.out.println("40: sap xep sp theo gia");
                System.out.println("41: tim san pham theo ten");
                System.out.println("44: thoát.");

                user = scanner.nextInt();
                switch (user) {
                    case 11:
                        new ProfileView();
                        break;
                    case 22:
                        new Main();
                        break;

                    case 32:
                        new CategoryView().creatCategoryView();
                        break;

                    case 33:
                        new CategoryView().showListCategory();
                        break;
                    case 34:
                        new CategoryView().findById();
                        break;
                    case 35:
                        new ProductView().showListProduct();
                        break;
                    case 36:
                        new CategoryView().creatCategoryView();
                        break;
                    case 37:
                        new ProductView().findByIdProduct();
                        break;
                    case 38:
                        new CategoryView().ediCategory();
                        break;
                    case 39:
                        new ProductView().editByIdProduct();
                        break;
                    case 40:
                        System.out.println("tim theo khoang gia");
                        new ProductView().sapXepPrice();
                        break;
                    case 41:
                        new CategoryView().findByNameCategory();
                        break;
                    case 44:
                        System.exit(1);
                    default:
                        System.out.println("nhap so theo danh sach");
                        new Main();
                        break;
                }
            }
        }

    }

    public static void main(String[] args) {
        // write your code here
        new Main();
    }
}
