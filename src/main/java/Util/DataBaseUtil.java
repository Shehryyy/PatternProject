package Util;

import org.example.Model.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataBaseUtil {
    public static final String DBPath = "jdbc:sqlite:src/main/resources/DataBase/Data.db";

    /**
     * makes a connection with the database
     *
     * @return connection
     */
    public static Connection connect() {
        Connection connection;
        try {
            connection = DriverManager.getConnection(DBPath);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }

    /**
     * creates the customer table in the database if it already doesn't exist
     */
    public static void createCustomerTable() {
        String sql = """
                CREATE TABLE IF NOT EXISTS customer(
                userName TEXT PRIMARY KEY,
                email TEXT NOT NULL,
                password TEXT NOT NULL,
                )
                """;

        try (Connection conn = connect();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Table created successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * creates the product table in the database if it already doesn't exist
     */
    public static void createProductTable() {
        String sql = """
                CREATE TABLE IF NOT EXISTS product(
                id INTEGER PRIMARY KEY,
                price NUMBER NOT NULL,
                quantity INTEGER NOT NULL,
                type TEXT NOT NULL,
                )
                """;

        try (Connection conn = connect();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Table created successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * creates the order table in the database if it already doesn't exist
     */
    public static void createOrderTable() {
        String sql = """
                CREATE TABLE IF NOT EXISTS order(
                id TEXT PRIMARY KEY,
                date DATE NOT NULL,
                )
                """;
        try (Connection connection = connect();
             Statement statement = connection.createStatement()) {
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * drops the customer table in the database if it exists
     */
    public static void dropCustomerTable() {
        String sql = "DROP TABLE IF EXISTS customer";
        try (Connection connection = connect();
             Statement statement = connection.createStatement()) {
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * drops the product table in the database if it exists
     */
    public static void dropProductTable() {
        String sql = "DROP TABLE IF EXISTS products";
        try (Connection connection = connect();
             Statement statement = connection.createStatement()) {
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * drops the order table in the database if it exists
     */
    public static void dropOrderTable() {
        String sql = "DROP TABLE IF EXISTS order";
        try (Connection connection = connect();
             Statement statement = connection.createStatement()) {
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * retrieves all customers from the database
     *
     * @return a list of all customers
     */
    public static List<Customer> getAllCustomers() {
        String sql = "SELECT * FROM customers";
        List<Customer> customers = new ArrayList<>();
        try (Connection connection = connect();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.getResultSet()) {
            while (rs.next()) {
                String userName = rs.getString("userName");
                String email = rs.getString("email");
                String password = rs.getString("password");
                customers.add(new Customer(userName, email, password));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return customers;
    }

    /**
     * retrieves all products from the database
     *
     * @return a list of all products
     */
    public static List<Product> getAllProducts() {
        String sql = "SELECT * FROM products";
        List<Product> products = new ArrayList<>();
        try (Connection connection = connect();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(sql)) {
            while (rs.next()) {
                int id = rs.getInt("id");
                double price = rs.getDouble("price");
                int quantity = rs.getInt("quantity");
                String type = rs.getString("type");
                if (type.equals("Electronics")) {
                    products.add(new Electronics(id, price, quantity));
                } else if (type.equals("Clothing")) {
                    products.add(new Clothing(id, price, quantity));
                } else if (type.equals("Video Game")) {
                    products.add(new VideoGame(id, price, quantity));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return products;
    }

    /**
     * retrieves all orders from the database
     *
     * @return a list of all orders
     */
    public static List<Order> getAllOrders() {
        String sql = "SELECT * FROM orders";
        List<Order> orders = new ArrayList<>();
        try (Connection connection = connect();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(sql)) {
            while (rs.next()) {
                String id = rs.getString("id");
                String date = rs.getString("date");
                orders.add(new Order(id, date));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return orders;
    }

    /**
     * inserts the values of the passing object to the database (customer table)
     * @param customer is the object to be passed
     */
    public static void insertToCustomer(Customer customer) {
        String sql = "INSERT INTO customers (userName, email, password) VALUES (?, ?, ?)";
        try(Connection connection = connect();
        PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, customer.getUserName());
            preparedStatement.setString(2, customer.getEmail());
            preparedStatement.setString(3, customer.getPassword());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * inserts the passing values to the database as a new record (customer table)
     * @param userName is the customer username
     * @param email is the customer email
     * @param password is the customer password
     */
    public static void insertToCustomer(String userName, String email, String password) {
        String sql = "INSERT INTO customers (userName, email, password) VALUES (?, ?, ?)";
        try(Connection connection = connect();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, userName);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, password);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * inserts the values of the passing object to the database (product table)
     * @param product is the object to be passed
     */
    public static void insertToProduct(Product product) {
        String sql = "INSERT INTO products (id, price, quantity, type) VALUES (?, ?, ?, ?)";
        try(Connection connection = connect();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1,product.getProductID());
            preparedStatement.setDouble(2,product.getPrice());
            preparedStatement.setInt(3,product.getQuantity());
            preparedStatement.setString(4,product.getType());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * inserts the passing values to the database as a new record (product table)
     * @param id is the product id
     * @param price is the product price
     * @param quantity is the product quantity
     * @param type is the product type
     */
    public static void insertToProduct(int id, double price, int quantity, String type) {
        String sql = "INSERT INTO products (id, price, quantity, type) VALUES (?, ?, ?, ?)";
        try(Connection connection = connect();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1,id);
            preparedStatement.setDouble(2,price);
            preparedStatement.setInt(3, quantity);
            preparedStatement.setString(4,type);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * inserts the values of the passing object to the database (order table)
     * @param order is the object to be passed
     */
    public static void insertToOrder(Order order) {
        String sql = "INSERT INTO orders (id, date) VALUES (?, ?)";
        try(Connection connection = connect();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1,order.getOrderID());
            preparedStatement.setString(2,order.getOrderDate());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * inserts the passing values to the database as a new record (order table)
     * @param id is the order id
     * @param date is the order placing date
     */
    public static void insertToOrder(String id, String date) {
        String sql = "INSERT INTO orders (id, date) VALUES (?, ?)";
        try(Connection connection = connect();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1,id);
            preparedStatement.setString(2,date);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}