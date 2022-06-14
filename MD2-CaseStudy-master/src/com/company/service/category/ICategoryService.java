package com.company.service.category;

import com.company.model.Category;
import com.company.model.Product;
import com.company.service.IServiceGeneric;

import java.util.List;

public interface ICategoryService extends IServiceGeneric<Category> {
    Category findById(int id);
    Category deleteById(int id);
    List<Category> findByNameProduct(String name);
}
