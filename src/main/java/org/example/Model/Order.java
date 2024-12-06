package org.example.Model;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private String orderId;
    private int nextId = 1;
    private List<Product> products;
    private LocalDateTime orderDate;
    private String status;

    // Constructor
    public Order(List<Product> products, String status) {
        this.orderId = String.valueOf(nextId++);  // Use String as the id
        this.products = new ArrayList<>(products);
        this.orderDate = LocalDateTime.now();
        this.status = status;
    }

    // Constructor for Orders with status
    public Order(String status) {
        this.orderId = String.valueOf(nextId++);  // Use String as the id
        this.products = new ArrayList<>();
        this.orderDate = LocalDateTime.now();
        this.status = status;
    }

    // Getters and setters
    public String getOrderId() {
        return orderId;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // Method to calculate the total cost
    public double calculateTotalCost() {
        double total = 0.0;
        for (Product product : products) {
            total += product.getPrice() * product.getQuantity();
        }
        return total;
    }

    // Adding/removing products
    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(Product product) {
        products.remove(product);
    }

    @Override
    public String toString() {
        StringBuilder productDetails = new StringBuilder();
        for (Product product : products) {
            productDetails.append(product.getDetails()).append("\n");
        }
        return "Order ID: " + orderId +
                "\nProducts: \n" + productDetails.toString() +
                "Order Date: " + orderDate +
                "\nStatus: " + status +
                "\nTotal Cost: $" + calculateTotalCost();
    }
}