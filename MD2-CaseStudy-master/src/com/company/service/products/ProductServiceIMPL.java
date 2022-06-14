package com.company.service.products;

import com.company.config.ConfigReadAndWirte;
import com.company.model.Category;
import com.company.model.Product;
import com.company.model.User;
import com.company.service.user_principal.UserPrincipalServiceIMPL;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ProductServiceIMPL implements IProductService {
    public static String PATH_PRODUCT = ConfigReadAndWirte.PATH + "product.txt";
    public static List<Product> productList = new ConfigReadAndWirte<Product>().readFromFile(PATH_PRODUCT);

    @Override
    public List<Product> findAll() {
        new ConfigReadAndWirte<Product>().writeToFile(PATH_PRODUCT, productList);
        return productList;
    }

    @Override
    public void save(Product product) {
        User user = new UserPrincipalServiceIMPL().getCurrentUser();
        product.setUser(user);
        productList.add(product);
    }



    @Override
    public Product findByIdProduct(int id) {
        for (int i = 0; i < productList.size(); i++) {
            if (id==productList.get(i).getId()){
                return productList.get(i);
            }
        }
        return null;
    }

    @Override
    public Product deleteById(int id) {
        for (int i = 0; i < productList.size(); i++) {
            if (id == productList.get(i).getId()){
                productList.remove(productList.get(i));
            }
        }
        return null;
    }

    @Override
    public void sortByPrice() {

    }

//    @Override
//    public void sortByPrice() {
//        Collections.sort(productList, new Comparator<Product>() {
//            @Override
//            public int compare(Product o1, Product o2) {
//                if () {
//                    return -1;
//                }
//                return 1;
//            }
//        });
//    }


}
