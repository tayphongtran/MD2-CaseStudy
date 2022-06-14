package com.company.service.category;

import com.company.config.ConfigReadAndWirte;
import com.company.model.Category;
import com.company.model.Product;
import com.company.model.User;
import com.company.service.products.ProductServiceIMPL;
import com.company.service.user_principal.UserPrincipalServiceIMPL;

import java.util.ArrayList;
import java.util.List;

public class CategoryServiceIMPL implements ICategoryService {
    public static String PATH_CATEGORY = ConfigReadAndWirte.PATH + "category.txt";
    public static List<Category> categoryList = new ConfigReadAndWirte<Category>().readFromFile(PATH_CATEGORY);

    @Override
    public List<Category> findAll() {
        new ConfigReadAndWirte<Category>().writeToFile(PATH_CATEGORY, categoryList);
        return categoryList;
    }

    @Override
    public void save(Category category) {
        User user = new UserPrincipalServiceIMPL().getCurrentUser();
        category.setUser(user);
        categoryList.add(category);
    }


    @Override
    public Category findById(int id) {
        for (int i = 0; i < categoryList.size(); i++) {
            if (id == categoryList.get(i).getId()) {
                return categoryList.get(i);
            }
        }
        return null;

    }

    @Override
    public Category deleteById(int id) {
        for (int i = 0; i < categoryList.size(); i++) {
            if (id == categoryList.get(i).getId()) {
                categoryList.remove(categoryList.get(i));
            }
        }
        return null;
    }

    @Override
    public List<Category> findByNameProduct(String name) {
        int id = 0;
        for (int i = 0; i < categoryList.size(); i++) {
            if (name.equalsIgnoreCase(categoryList.get(i).getNameCategory())){
                System.out.println(categoryList);
                return categoryList;
            }
        }
        return null;
    }

//    @Override
//    public List<Product> findByIdProduct(String name) {
//        List<Product>   productList = new ArrayList<>();
//        for (int i = 0; i < new ProductServiceIMPL().findAll().size(); i++) {
//            if (name.equalsIgnoreCase(new ProductServiceIMPL().findAll().get(i).getCategory().getNameCategory())){
//                productList.add(new ProductServiceIMPL().findAll().get(i));
//            }
//        }
//        return null;
//    }


}