package org.example.Model;

public class Clothing extends Product {
    private String size;
    private String color;
    private String type;

    public Clothing(int productID, double price, int quantity, String size, String color, String type) {
        super(productID, price, quantity);
        this.size = size;
        this.color = color;
        this.type = type;
    }

    public String getSize() {
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
