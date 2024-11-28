package org.example.Model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static Util.DataBaseUtil.DBPath;
import static Util.DataBaseUtil.connect;

public class ProductDAO {
    public Product getProductById(int productId) {
        try (Connection conn = connect()) {
            String[] tables = {"VideoGame", "Clothing", "Electronics"};
            for (String table : tables) {
                String sql = "SELECT * FROM " + table + " WHERE ProductID = ?";
                try (PreparedStatement ps = conn.prepareStatement(sql)) {
                    ps.setInt(1, productId);
                    ResultSet rs = ps.executeQuery();
                    if (rs.next()) {
                        double price = rs.getDouble("Price");
                        int quantity = rs.getInt("Quantity");
                        String str1 = rs.getString(2);
                        String str2 = rs.getString(3);
                        String str3 = rs.getString(4);
                        return ProductFactory.createProduct(productId, price, quantity, table, str1, str2, str3);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
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
