package org.example.Model;

import java.util.*;

public class Order {
    private String orderID;
    private Date orderDate;

    public Order(String orderID, Date orderDate) {
        this.orderID = orderID;
        this.orderDate = orderDate;
    }

    public String getOrderDetails() {
        return "Order ID: " + orderID + ", order Date: " + orderDate;
    }
}
