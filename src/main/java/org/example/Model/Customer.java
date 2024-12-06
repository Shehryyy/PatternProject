package org.example.Model;

import java.sql.*;
import java.util.*;

import static Util.DataBaseUtil.connect;

public class Customer extends User {

    private List<Order> orderHistory;

    public Customer() {
    }

    public Customer(String userName, String email, String password) {
        super(userName, email, password);
        this.orderHistory = new ArrayList<>();
    }

    public List<Product> viewProducts() {
        ProductDAO productDAO = new ProductDAO();
        return productDAO.getAllProducts();
    }

    public Product searchProduct(int productID) {
        String productSql = "SELECT * FROM Product WHERE ProductID = ?";
        String videoGameSql = "SELECT * FROM VideoGame WHERE ProductID = ?";
        String clothingSql = "SELECT * FROM Clothing WHERE ProductID = ?";
        String electronicsSql = "SELECT * FROM Electronics WHERE ProductID = ?";

        try (Connection conn = connect()) {
            try (PreparedStatement productStmt = conn.prepareStatement(productSql)) {
                productStmt.setInt(1, productID);
                ResultSet productRs = productStmt.executeQuery();

                if (productRs.next()) {
                    double price = productRs.getDouble("Price");
                    int quantity = productRs.getInt("Quantity");

                    try (PreparedStatement videoGameStmt = conn.prepareStatement(videoGameSql)) {
                        videoGameStmt.setInt(1, productID);
                        ResultSet videoGameRs = videoGameStmt.executeQuery();
                        if (videoGameRs.next()) {
                            String platform = videoGameRs.getString("platform");
                            String genre = videoGameRs.getString("genre");
                            String name = videoGameRs.getString("name");
                            return new VideoGame(productID, price, quantity, platform, genre, name);
                        }
                    }

                    try (PreparedStatement clothingStmt = conn.prepareStatement(clothingSql)) {
                        clothingStmt.setInt(1, productID);
                        ResultSet clothingRs = clothingStmt.executeQuery();
                        if (clothingRs.next()) {
                            String size = clothingRs.getString("size");
                            String color = clothingRs.getString("color");
                            String type = clothingRs.getString("type");
                            return new Clothing(productID, price, quantity, size, color, type);
                        }
                    }

                    try (PreparedStatement electronicStmt = conn.prepareStatement(electronicsSql)) {
                        electronicStmt.setInt(1, productID);
                        ResultSet electronicRs = electronicStmt.executeQuery();
                        if (electronicRs.next()) {
                            String company = electronicRs.getString("company");
                            String storage = electronicRs.getString("storage");
                            String model = electronicRs.getString("model");
                            return new Electronics(productID, price, quantity, company, storage, model);
                        }
                    }
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Error searching for product with ID " + productID, e);
        }
        return null;
    }
}
