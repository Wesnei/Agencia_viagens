package db;

import java.sql.*;

public class MyJDBC {

    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3306/travel_schema",
                    "root",
                    "9ZDTCpt6@"
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
