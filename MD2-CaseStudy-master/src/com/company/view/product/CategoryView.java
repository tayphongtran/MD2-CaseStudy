package com.company.view.product;

import com.company.controller.CategoryController;
import com.company.controller.ProductController;
import com.company.model.Category;
import com.company.model.Product;
import com.company.service.category.CategoryServiceIMPL;
import com.company.service.products.ProductServiceIMPL;
import com.company.view.Main;

import java.util.List;
import java.util.Scanner;

public class CategoryView {
    CategoryServiceIMPL categoryServiceIMPL = new CategoryServiceIMPL();
    CategoryController categoryController = new CategoryController();
    ProductServiceIMPL productServiceIMPL = new ProductServiceIMPL();

    List<Category> categoryList = categoryServiceIMPL.categoryList;
    List<Product> productList = productServiceIMPL.productList;

    Scanner scanner = new Scanner(System.in);

    public void creatCategoryView() {
        while (true) {
            System.out.println(" Tạo sản phẩm: ");
            String nameCategory = scanner.nextLine();
            new CategoryController().creatCategory(nameCategory);
            System.out.println("enter to continue creating products ");
            System.out.println("enter quit to back menu: ");
            String backMenu = scanner.nextLine();
            if (backMenu.equalsIgnoreCase("quit")) {

                new Main();
            }
        }

    }

    public void showListCategory() {
        System.out.println(categoryController.showListCategory());
        System.out.println("enter quit to back menu: ");
        String backMenu = scanner.nextLine();
        if (backMenu.equalsIgnoreCase("quit")) {

            new Main();
        }
    }

    public void ediCategory() {
        System.out.println("Edit category");
        System.out.print("Enter id you want to edit: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter new category name: ");
        String categoryName = scanner.nextLine();
        categoryController.editFindById(id, categoryName);
        new Main();
    }

    public void findById() {
        System.out.println("nhap ID Category can tim:");
        int id = scanner.nextInt();
        System.out.println(categoryServiceIMPL.findById(id));
        System.out.println("enter quit to back menu: ");
        scanner.nextLine();
        String backMenu = scanner.nextLine();
        if (backMenu.equalsIgnoreCase("quit")) {
            new Main();
        }
    }

    public void deletedByidCategory() {
        System.out.println(categoryController.showListCategory());
        System.out.println("nhap ID Category muon xoa");
        int category = scanner.nextInt();
        categoryController.deleteByIds(category);
        System.out.println("enter quit to back menu: ");
        scanner.nextLine();
        String backMenu = scanner.nextLine();
        if (backMenu.equalsIgnoreCase("quit")) {
            new Main();
        }
    }

    public void findByIdProduct() {
        System.out.println("Nhap ID :");
        int id = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < ProductServiceIMPL.productList.size(); i++) {
            if (id == ProductServiceIMPL.productList.get(i).getCategory().getId()) {
                System.out.println(ProductServiceIMPL.productList.get(i));
            }
        }
        System.out.println("enter quit to back menu: ");
//        scanner.nextLine();
        String backMenu = scanner.nextLine();
        if (backMenu.equalsIgnoreCase("quit")) {
            new Main();
        }

    }

    public void findByNameCategory() {
        System.out.println("nhap ten the loai san muon tim: ");
        String name = scanner.nextLine();
//        System.out.println(categoryController.findByIdProduct(name));
        for (int i = 0; i < ProductServiceIMPL.productList.size(); i++) {
            if (name.equalsIgnoreCase(productList.get(i).getCategory().getNameCategory())) {
                System.out.println(ProductServiceIMPL.productList.get(i));
            }
        }
        new Main();

    }
}