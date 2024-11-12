package org.example.Model;

import java.sql.*;
import java.util.*;

import static Util.DataBaseUtil.DBPath;
import static Util.DataBaseUtil.connect;

public class Customer extends User {

    private List<Order> orderHistory;

    public Customer() {
    }

    public Customer(String userName, String email, String password, Role role) {
        super(userName, email, password, Role.CUSTOMER);
        this.orderHistory = new ArrayList<Order>();
    }

//    public List<Product> viewProducts() {
//        List<Product> products = new LinkedList<Product>();
//
//        String sql = "SELECT * FROM Product";
//
//        try (Connection conn = connect(DBPath);
//        Statement statement = conn.createStatement();
//           ResultSet rs = statement.executeQuery(sql)) {
//
//            while (rs.next()) {
//                int id = rs.getInt("ProductID");
//                double price = rs.getDouble("Price");
//                int quantity = rs.getInt("Quantity");
//
//                products.add(new Product(id, price, quantity).getDetails());
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//        return products;
//    }

    public Product searchProduct(int productID) {
        String productSql = "SELECT * FROM Product WHERE ProductID = ?";
        String videoGameSql = "SELECT * FROM VideoGame WHERE ProductID = ?";
        String clothingSql = "SELECT * FROM Clothing WHERE ProductID = ?";
        String electronicsSql = "SELECT * FROM Electronics WHERE ProductID = ?";

        try (Connection conn = connect(DBPath)) {
            try (PreparedStatement productStmt = conn.prepareStatement(productSql)) {
                productStmt.setInt(1, productID);
                ResultSet productRs = productStmt.executeQuery();

                if (productRs.next()) {
                    double price = productRs.getDouble("Price");
                    int quantity = productRs.getInt("Quantity");

                    try(PreparedStatement videoGameStmt = conn.prepareStatement(videoGameSql)) {
                        videoGameStmt.setInt(1, productID);
                        ResultSet videoGameRs = videoGameStmt.executeQuery();

                        if (videoGameRs.next()) {
                            String platform = videoGameRs.getString("Platform");
                            String genre = videoGameRs.getString("Genre");
                            String name = videoGameRs.getString("Name");
                            return new VideoGame(productID, price, quantity, platform, genre, name);
                        }
                    }

                    try(PreparedStatement clothingStmt = conn.prepareStatement(clothingSql)) {
                        clothingStmt.setInt(1, productID);
                        ResultSet clothingRs = clothingStmt.executeQuery();

                        if (clothingRs.next()) {
                            String size = clothingRs.getString("Size");
                            String color = clothingRs.getString("Color");
                            String type = clothingRs.getString("Type");
                                return new Clothing(productID, price, quantity, size, color, type);
                        }
                    }

                    try(PreparedStatement electronicStmt = conn.prepareStatement(videoGameSql)) {
                        electronicStmt.setInt(1, productID);
                        ResultSet electronicRs = electronicStmt.executeQuery();

                        if (electronicRs.next()) {
                            String company = electronicRs.getString("Company");
                            String storage = electronicRs.getString("Storage");
                            String model = electronicRs.getString("Model");
                            return new Electronics(productID, price, quantity, company, storage, model);
                        }
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
