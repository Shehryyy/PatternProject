package Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseUtil {
    public static final String DBPath = "jdbc:sqlite:src/main/resources/DataBase/Data.db";

    /**
     * makes a connection with the database
     * @return connection
     */
    public static Connection connect() {
        Connection connection;
        try
        {
            connection = DriverManager.getConnection(DBPath);
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
        return connection;
    }

    public static void dropTable(String statementStr) {
        try(Connection connection = connect();
        Statement statement = connection.createStatement()){
            statement.executeUpdate(statementStr);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void createCustomerTable() {
        String sql = "CREATE TABLE IF NOT EXISTS customers";

        try (Connection conn = connect();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Table created successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void createProductTable() {
        String sql = "CREATE TABLE IF NOT EXISTS products";

        try (Connection conn = connect();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Table created successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}
