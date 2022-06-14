package com.company.controller;

import com.company.model.Category;
import com.company.model.Product;
import com.company.service.category.CategoryServiceIMPL;
import com.company.service.products.ProductServiceIMPL;

import java.util.List;

public class CategoryController {
    CategoryServiceIMPL categoryServiceIMPL = new CategoryServiceIMPL();

    public CategoryController() {

    }


    public void creatCategory(String nameCategory) {
        int id;
        if (categoryServiceIMPL.findAll().size() == 0) {
            id = 1;
        } else {
            id = categoryServiceIMPL.categoryList.get(categoryServiceIMPL.categoryList.size() - 1).getId() + 1;
        }
        Category category = new Category(id, nameCategory);
        categoryServiceIMPL.save(category);
        categoryServiceIMPL.findAll();
    }

    public List<Category> showListCategory() {
        return categoryServiceIMPL.findAll();
    }

    public void editFindById(int id, String nameCategory) {
        System.out.println(nameCategory + "=======");
        Category category = categoryServiceIMPL.findById(id);
        category.setNameCategory(nameCategory);
        categoryServiceIMPL.findAll();
    }

    public Category findById(int id) {
      return   categoryServiceIMPL.findById(id);
    }
    public Category deleteByIds(int id){
        return categoryServiceIMPL.deleteById(id);
    }

    public List<Category> findByIdProduct(String name){
        return categoryServiceIMPL.findByNameProduct(name);
    }

}
