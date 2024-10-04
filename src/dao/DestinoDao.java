package dao;

import db.MyJDBC;
import models.Destino;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DestinoDao {

    public boolean inserir(Destino destino) {
        Connection connection = MyJDBC.getConnection();

        String sql = "INSERT INTO `travel_schema`.`destino` (`nome`, `descricao`, `pacoteId`) VALUES (?, ?, ?)";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, destino.getNome());
            stmt.setString(2, destino.getDescricao());
            stmt.setInt(3, destino.getPacoteId());

            stmt.executeUpdate();
            System.out.println("Destino inserido com sucesso!");

            return true;

        } catch (SQLException e) {

            if (e.getMessage().contains("foreign key constraint fails")) {
                return false;
            } else {
                e.printStackTrace();
            }

            return false;

        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public List<Destino> listar() {
        List<Destino> destinos = new ArrayList<>();
        Connection connection = MyJDBC.getConnection();
        String sql = "SELECT d.id, d.nome AS destinoNome, d.descricao AS destinoDescricao, d.pacoteId, p.nome AS pacoteNome " +
                "FROM destino d " +
                "JOIN pacote_turistico p ON d.pacoteId = p.id";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Destino destino = new Destino(
                        rs.getInt("id"),
                        rs.getString("destinoNome"),
                        rs.getString("destinoDescricao"),
                        rs.getInt("pacoteId")
                );


                destino.setPacoteNome(rs.getString("pacoteNome"));
                destinos.add(destino);
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
        return destinos;
    }
}
