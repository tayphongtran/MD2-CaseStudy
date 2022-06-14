package com.company.view.product;

import com.company.controller.CategoryController;
import com.company.controller.ProductController;
import com.company.model.Category;
import com.company.model.Product;
import com.company.service.category.CategoryServiceIMPL;
import com.company.service.products.ProductServiceIMPL;
import com.company.view.Main;

import java.util.Scanner;

public class ProductView {
    ProductController productController = new ProductController();
    ProductServiceIMPL productServiceIMPL = new ProductServiceIMPL();

    Scanner scanner = new Scanner(System.in);

    public void productView() {

    }

    public void creatProduct() {
        while (true) {
            int id;
            if (productServiceIMPL.findAll().size() == 0) {
                id = 1;
            } else {
                id = productServiceIMPL.findAll().get(productServiceIMPL.findAll().size() - 1).getId() + 1;
            }
            System.out.println("nhap product: ");
            String nameProduct = scanner.nextLine();
            System.out.println("nhap descriptionProduct: ");
            String descriptionProduct = scanner.nextLine();
            System.out.println("nhap priceProduct: ");
            int priceProduct = scanner.nextInt();
            System.out.println("nhap id catagory: ");
            int idCategory = scanner.nextInt();
            Category category = new CategoryController().findById(idCategory);
            Product product = new Product(id, nameProduct, descriptionProduct, priceProduct, category);
            productController.creatProduct(product);

            System.out.println(productController.showListProduct());
            System.out.println("enter to continue creating products ");
            System.out.println("enter quit to back menu: ");
            scanner.nextLine();
            String backMenu = scanner.nextLine();
            if (backMenu.equalsIgnoreCase("quit")) {
                new Main();
            }
        }

    }

    public void showListProduct() {
        System.out.println(productController.showListProduct());
        System.out.println("enter quit to back menu: ");
//        scanner.nextLine();
        String backMenu = scanner.nextLine();
        if (backMenu.equalsIgnoreCase("quit")) {
            new Main();
        }
    }

    public void findByIdProduct() {
      while (true){
          System.out.println("nhap ID product can tim: ");
          int idProdcut = scanner.nextInt();
          System.out.println(productController.findbyid(idProdcut));
          System.out.println("enter to continue find products:  ");
          scanner.nextLine();
          System.out.println("enter quit to back menu: ");
//          scanner.nextLine();
          String backMenu = scanner.nextLine();
          if (backMenu.equalsIgnoreCase("quit")) {
              new Main();
          }
      }
    }

    public void editByIdProduct() {
        while (true) {
            System.out.println("edit ID product: ");
            int firstIdEditProduct = scanner.nextInt();
            System.out.println(productController.findbyid(firstIdEditProduct));
            System.out.println("edit id: ");
            int lastIdEditProduct = scanner.nextInt();
            System.out.println("edit name product: ");
            scanner.nextLine();
            String editName = scanner.nextLine();
            System.out.println("edit description: ");
            String editDescription = scanner.nextLine();
            System.out.println("edit price product: ");
            int editPrice = scanner.nextInt();
            productController.editFindByIdProduct(lastIdEditProduct, editName, editDescription, editPrice);
            System.out.println("thong tin cap nhat: ");
            System.out.println(productController.showListProduct());
            System.out.println("enter to continue edit products:  ");
            System.out.println("enter quit to back menu: ");
            scanner.nextLine();
            String backMenu = scanner.nextLine();
            if (backMenu.equalsIgnoreCase("quit")) {
                new Main();
            }
        }
    }
    public void deleteByIdProduct(){
        while (true){
            System.out.println(productController.showListProduct());
//            System.out.println("enter to continue delete by id product: ");
            System.out.println("neu ban khong muon xoa thi nhap 0: ");
            System.out.println("nhap Id product muon xoa: ");
            int deleteByIdProduct = scanner.nextInt();
            productController.deleteIdProduct(deleteByIdProduct);
            System.out.println("enter quit to back menu: ");
            scanner.nextLine();

            String backMenu = scanner.nextLine();
            if (backMenu.equalsIgnoreCase("quit")) {
                new Main();
            }
        }
    }

    public void showCategoryByIdProduct(){
        System.out.println("nhap Id de hien thi danh sach :");
        int id = scanner.nextInt();
        int count =0;
        for (int i = 0; i < CategoryServiceIMPL.categoryList.size(); i++) {
            if (id==ProductServiceIMPL.productList.get(i).getId()){
                System.out.println();
            }
        }
    }

    public void sapXepPrice(){
        System.out.println(productController.showListProduct());
        productController.sapXepPrice();
        System.out.println(productController.showListProduct());

        System.out.println("enter quit to back menu: ");
        scanner.nextLine();

        String backMenu = scanner.nextLine();
        if (backMenu.equalsIgnoreCase("quit")) {
            new Main();
        }
    }
}
