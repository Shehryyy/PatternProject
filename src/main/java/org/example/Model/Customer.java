package org.example.Model;

import java.sql.*;
import java.util.*;

import static Util.DataBaseUtil.DBPath;
import static Util.DataBaseUtil.connect;

public class Customer extends User {

    private List<Order> orderHistory;

    public Customer() {
    }

    public Customer(String userName, String email, String password) {
        super(userName, email, password);
        this.role = Role.CUSTOMER;
        this.orderHistory = new ArrayList<Order>();
    }

    public List<Product> viewProducts(ProductDAO productDAO) {
        return productDAO.getAllProducts();
    }

    public Product searchProduct(int productID) {
        ProductDAO productDAO = new ProductDAO();
        return productDAO.getProductById(productID);
    }

}
