package Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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
}
