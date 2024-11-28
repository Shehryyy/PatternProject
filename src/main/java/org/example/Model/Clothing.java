package org.example.Model;

public class Clothing extends Product {
    private double size;
    private String color;

    public Clothing(int productID, double price, int quantity) {
        super(productID, price, quantity);
    }

    public Clothing(int productID, double price, int quantity, double size, String color, String type) {
        super(productID, price, quantity);
        this.size = size;
        this.color = color;
        this.type = "Clothing";
    }

    //we need setters since the constructor doesn't take these parameters
    public void setSize(double size) {
        this.size = size;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getSize() {
        return size;
    }

    public String getColor() {
        return color;
    }

    public String getType() {
        return type;
    }

    @Override
    public String getDetails() {
        return "Clothing:" + "\n" + "Size: " + size + "\n" + "Color: " + color + "\n" + "Type: " + type + "\n" + "Price: " + price + "\n" + "Quantity: " + quantity + "\n";
    }
}
