package org.example.Model;

public class ProductFactory {
    public static Product createProduct(int productId, double price, int quantity, String type, String str1, String str2, String str3) {
        switch (type) {
            case "VideoGame":
                return new VideoGame(productId, price, quantity, str1, str2, str3);
            case "Clothing":
                return new Clothing(productId, price, quantity, str1, str2, str3);
            case "Electronics":
                return new Electronics(productId, price, quantity, str1, str2, str3);
            default:
                throw new IllegalArgumentException("Invalid product type: " + type);
        }

    }
}
