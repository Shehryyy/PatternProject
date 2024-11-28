package org.example.Model;

public abstract class Product {
    protected int productID;
    protected double price;
    protected int quantity;
    protected String type;

    public Product() {
    }

    public Product(int productID, double price, int quantity) {
        this.productID = productID;
        this.price = price;
        this.quantity = quantity;
    }

    public abstract String getDetails();

    public int getProductID() {
        return productID;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getType() {
        return type;
    }
}
