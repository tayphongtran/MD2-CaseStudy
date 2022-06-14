package com.company.service.products;

import com.company.model.Category;
import com.company.model.Product;
import com.company.service.IServiceGeneric;

import java.util.Collection;

public interface IProductService extends IServiceGeneric<Product> {
    Product findByIdProduct(int id);
    Product deleteById(int id);
    void sortByPrice();


}
