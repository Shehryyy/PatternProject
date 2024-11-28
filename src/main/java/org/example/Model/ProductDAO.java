package org.example.Model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static Util.DataBaseUtil.DBPath;
import static Util.DataBaseUtil.connect;

public class ProductDAO {

    public Product getProductById(int productId) {
        String productSql = "SELECT * FROM product WHERE id = ?";
        String videoGameSql = "SELECT * FROM video_games WHERE id = ?";
        String clothingSql = "SELECT * FROM clothings WHERE id = ?";
        String electronicsSql = "SELECT * FROM electronics WHERE id = ?";

        try (Connection conn = connect()) {
            try (PreparedStatement productStmt = conn.prepareStatement(productSql)) {
                productStmt.setInt(1, productId);
                ResultSet productRs = productStmt.executeQuery();

                if (productRs.next()) {
                    double price = productRs.getDouble("price");
                    int quantity = productRs.getInt("quantity");

                    try (PreparedStatement videoGameStmt = conn.prepareStatement(videoGameSql)) {
                        videoGameStmt.setInt(1, productId);
                        ResultSet videoGameRs = videoGameStmt.executeQuery();

                        if (videoGameRs.next()) {
                            String platform = videoGameRs.getString("platform");
                            String genre = videoGameRs.getString("genre");
                            String name = videoGameRs.getString("name");
                            return new VideoGame(productId, price, quantity, platform, genre, name);
                        }
                    }

                    try (PreparedStatement clothingStmt = conn.prepareStatement(clothingSql)) {
                        clothingStmt.setInt(1, productId);
                        ResultSet clothingRs = clothingStmt.executeQuery();

                        if (clothingRs.next()) {
                            String size = clothingRs.getString("size");
                            String color = clothingRs.getString("color");
                            String type = clothingRs.getString("type");
                            return new Clothing(productId, price, quantity, size, color, type);
                        }
                    }

                    try (PreparedStatement electronicStmt = conn.prepareStatement(electronicsSql)) {
                        electronicStmt.setInt(1, productId);
                        ResultSet electronicRs = electronicStmt.executeQuery();

                        if (electronicRs.next()) {
                            String company = electronicRs.getString("company");
                            String storage = electronicRs.getString("storage");
                            String model = electronicRs.getString("model");
                            return new Electronics(productId, price, quantity, company, storage, model);
                        }
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT ProductID FROM Product";

        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                int productId = rs.getInt("ProductID");
                Product product = getProductById(productId);
                if (product != null) {
                    products.add(product);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

//    public void addProduct(Product product) {
//        String sql = "INSERT INTO Product (ProductID, Price, Quantity) VALUES (?, ?, ?)";
//
//        try (Connection conn = connect();
//        PreparedStatement stmt = conn.prepareStatement(sql)) {
//
//            stmt.setInt(1, product.getProductID());
//            stmt.setDouble(2, product.getPrice());
//            stmt.setInt(3, product.getQuantity());
//            stmt.executeUpdate();
//
//            String newSql = "INSERT INTO " + product.getClass().getSimpleName() + " VALUES (?, ?, ?, ?)";
//            try (PreparedStatement ps = conn.prepareStatement(newSql)) {
//                ps.setInt(1, product.getProductID());
//                if (product instanceof VideoGame) {
//                    VideoGame videoGame = (VideoGame) product;
//                    ps.setString(2, videoGame.getPlatform());
//                    ps.setString(3, videoGame.getGenre());
//                    ps.setString(4, videoGame.getName());
//                } else if (product instanceof Clothing) {
//                    Clothing clothing = (Clothing) product;
//                    ps.setString(2, clothing.getSize());
//                    ps.setString(3, clothing.getColor());
//                    ps.setString(4, clothing.getType());
//                } else if (product instanceof Electronics) {
//                    Electronics electronics = (Electronics) product;
//                    ps.setString(2, electronics.getCompany());
//                    ps.setString(3, electronics.getStorage());
//                    ps.setString(4, electronics.getModel());
//                }
//                ps.executeUpdate();
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
}
