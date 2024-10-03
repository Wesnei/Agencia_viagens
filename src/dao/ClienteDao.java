package dao;

import db.MyJDBC;
import models.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ClienteDao {
    public void inserir(Cliente cliente) {
        Connection connection = MyJDBC.getConnection();

        String sql = "INSERT INTO `travel_schema`.`cliente` (`id`, `cpf`) VALUES (?, ?)";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, cliente.getId());
            stmt.setInt(2, cliente.getCpf());

            stmt.executeUpdate();
            System.out.println("Cliente inserido com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
