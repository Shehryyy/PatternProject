package org.example.Model;

public class ProductFactory {
    public static Product createProduct(int productId, double price, int quantity, String type, String str1, String str2, String str3) {
        return switch (type) {
            case "VideoGame" -> new VideoGame(productId, price, quantity);
            case "Clothing" -> new Clothing(productId, price, quantity);
            case "Electronics" -> new Electronics(productId, price, quantity);
            default -> throw new IllegalArgumentException("Invalid product type: " + type);
        };
    }
}
