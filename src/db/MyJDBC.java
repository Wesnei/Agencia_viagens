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
            System.out.println("Conexão Estabelecida com Sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao Estabelecer Conexão com o Banco de Dado " + e.getMessage());
            e.printStackTrace();
        }
        return connection;
    }
}
