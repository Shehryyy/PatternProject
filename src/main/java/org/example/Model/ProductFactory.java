package org.example.Model;

public class ProductFactory {

    public static Product createProduct(int productId, double price, int quantity, String type, String str1, String str2, String str3) {
        return switch (type) {
            case "VideoGame" -> new VideoGame(productId, price, quantity, str1, str2, str3);  // str1 -> name, str2 -> platform, str3 -> genre
            case "Clothing" -> new Clothing(productId, price, quantity, str1, str2, str3);    // str1 -> size, str2 -> color, str3 -> style
            case "Electronics" -> new Electronics(productId, price, quantity, str1, str2, str3); // str1 -> company, str2 -> storage, str3 -> model
            default -> throw new IllegalArgumentException("Invalid product type: " + type);
        };
    }
}
