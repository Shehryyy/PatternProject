package org.example.Model;

public class Clothing extends Product {
    private String size;
    private String color;
    private String style;
    private String type;

    public Clothing(int productID, double price, int quantity) {
        super(productID, price, quantity);
    }

    public Clothing(int productID, double price, int quantity, String size, String color, String style) {
        super(productID, price, quantity);
        this.size = size;
        this.color = color;
        this.style = style;
        this.type = "Clothing";
    }

    public String getSize() {
        return size;
    }

    public String getColor() {
        return color;
    }

    public String getStyle() {
        return style;
    }

    public String getType() {
        return type;
    }

    @Override
    public String getDetails() {
        return "\nClothing: \n" +
                "Product ID: " + productID + "\n" +
                "Size: " + size + "\n" +
                "Color: " + color + "\n" +
                "Style: " + style + "\n" +
                "Price: $" + getPrice() + "\n" +
                "Quantity: " + getQuantity();
    }
}

