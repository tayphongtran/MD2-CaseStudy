package com.company.controller;

import com.company.model.Category;
import com.company.model.Product;
import com.company.service.category.CategoryServiceIMPL;
import com.company.service.products.ProductServiceIMPL;

import java.util.List;

public class ProductController {
    CategoryServiceIMPL categoryServiceIMPL = new CategoryServiceIMPL();
    ProductServiceIMPL productServiceIMPL = new ProductServiceIMPL();
    public void creatProduct(Product product){
        productServiceIMPL.save(product);
      productServiceIMPL.findAll();
    }
    public List<Product> showListProduct(){
        return productServiceIMPL.findAll();
    }


    public Product  findbyid(int id){
        return productServiceIMPL.findByIdProduct(id);
    }

    public void editFindByIdProduct(int id, String name, String description, int price){
        Product product = productServiceIMPL.findByIdProduct(id);
        product.setNameProduct(name);
        product.setDescriptionProduct(description);
        product.setPrice(price);
        productServiceIMPL.findAll();
    }

    public Product deleteIdProduct(int id){
        return productServiceIMPL.deleteById(id);
    }

    public void sapXepPrice(){
        productServiceIMPL.sortByPrice();
    }
}
