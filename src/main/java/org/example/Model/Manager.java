package org.example.Model;

import java.util.*;

public class Manager extends User {
    private List<Product> products;

    public Manager(String username, String email, String password) {
        super(username, email, password);
        this.role = Role.MANAGER;
    }

    public void add(Product product, ProductDAO productDAO) {
        productDAO.addProduct(product);
        products.add(product);
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }


}
