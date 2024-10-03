package dao;

import db.MyJDBC;
import models.PacoteTuristico;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PacoteTuristicoDao {

    public void inserir(PacoteTuristico pacoteTuristico) {
        Connection connection = MyJDBC.getConnection();

        String sql = "INSERT INTO `travel_schema`.`pacote_turistico` (`nome`, `preco`, `descricao`) VALUES (?, ?, ?)";

        try {

            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, pacoteTuristico.getNome());
            stmt.setDouble(2, pacoteTuristico.getPreco());
            stmt.setString(3, pacoteTuristico.getDescricao());

            stmt.executeUpdate();
            System.out.println("Pacote Inserido com Sucesso!");

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
