package Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseUtil {
    public static final String DBPath = "jdbc:sqlite:src/main/resources/DataBase/Data.db";


    public static Connection connect(String path) {
        Connection connection;
        try
        {
            connection = DriverManager.getConnection(path);
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
        return connection;
    }

    public static void addTable(String statementStr) {
        try(Connection connection = connect(DBPath);
        Statement statement = connection.createStatement()){
            statement.executeUpdate(statementStr);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void dropTable(String statementStr) {
        try(Connection connection = connect(DBPath);
        Statement statement = connection.createStatement()){
            statement.executeUpdate(statementStr);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
