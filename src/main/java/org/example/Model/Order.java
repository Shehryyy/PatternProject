package org.example.Model;

import java.time.LocalDateTime;
import java.util.*;

public class Order {
    private String orderID;
    private String orderDate;

    public Order(String orderID, String orderDate) {
        this.orderID = orderID;
        this.orderDate = LocalDateTime.now().toString();
    }

    public String getOrderID() {
        return orderID;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public String getOrderDetails() {
        return "Order ID: " + orderID + ", order Date: " + orderDate;
    }
}
