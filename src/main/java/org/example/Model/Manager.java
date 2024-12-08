package org.example.Model;

import java.util.ArrayList;
import java.util.List;

public class Manager extends User {
    private List<Product> products;

    public Manager(String username, String email, String password) {
        super(username, email, password);
        this.products = new ArrayList<>();
        this.userName = "Manager";
        this.password = "Manager";
    }

    public void add(Product product, ProductDAO productDAO) {
        productDAO.addProduct(product);
        products.add(product);
    }

    public List<Product> getProducts() {
        ProductDAO dao = new ProductDAO();
        return dao.getAllProducts();
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
