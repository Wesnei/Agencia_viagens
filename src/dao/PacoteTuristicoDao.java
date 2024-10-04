package dao;

import db.MyJDBC;
import models.PacoteTuristico;
import models.Pessoa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PacoteTuristicoDao {

    public void inserir(PacoteTuristico pacoteTuristico) {
        Connection connection = MyJDBC.getConnection();

        String sql = "INSERT INTO `travel_schema`.`pacote_turistico` (`nome`, `preco`, `descricao`) VALUES (?, ?, ?)";

        try {

            PreparedStatement stmt = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            stmt.setString(1, pacoteTuristico.getNome());
            stmt.setDouble(2, pacoteTuristico.getPreco());
            stmt.setString(3, pacoteTuristico.getDescricao());

            stmt.executeUpdate();
            System.out.println("Pacote Inserido com Sucesso!");

            ResultSet rs = stmt.getGeneratedKeys();

            if (rs.next()) {
                int generatedId = rs.getInt(1);
                pacoteTuristico.setId(generatedId);
            }

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

    public List<PacoteTuristico> listar() {
        List<PacoteTuristico> pacoteTuristicos = new ArrayList<>();
        Connection connection = MyJDBC.getConnection();

        String sql = "SELECT * FROM `travel_schema`.`pacote_turistico`";

        try {

            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                PacoteTuristico pacoteTuristico = new PacoteTuristico(rs.getInt("id"), rs.getString("nome"), rs.getDouble("preco"), rs.getString("descricao"));
                pacoteTuristico.setId(rs.getInt("id"));
                pacoteTuristico.setNome(rs.getString("nome"));
                pacoteTuristico.setPreco(rs.getDouble("preco"));
                pacoteTuristico.setDescricao(rs.getString("descricao"));

                pacoteTuristicos.add(pacoteTuristico);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return pacoteTuristicos;

    }

}
