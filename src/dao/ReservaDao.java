package dao;

import db.MyJDBC;
import models.Reserva;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReservaDao {

    public boolean inserir(Reserva reserva) {
        Connection connection = MyJDBC.getConnection();
        String sql = "INSERT INTO `travel_schema`.`reserva` (`dataReserva`, `status`, `clienteId`, `pacoteId`) VALUES (?, ?, ?, ?)";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setDate(1, reserva.getDataReserva());
            stmt.setString(2, reserva.getStatus());
            stmt.setInt(3, reserva.getClienteId());
            stmt.setInt(4, reserva.getPacoteId());

            stmt.executeUpdate();
            System.out.println("Reserva inserida com sucesso!");

            return true;

        } catch (SQLException e) {
            if (e.getMessage().contains("foreign key constraint fails")){
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

    public List<Reserva> listar() {
        List<Reserva> reservas = new ArrayList<>();
        Connection connection = MyJDBC.getConnection();
        String sql = "SELECT r.id, r.dataReserva, r.status, c.cpf AS clienteCpf, p.nome AS pacoteNome " +
                "FROM reserva r " +
                "JOIN cliente c ON r.clienteId = c.id " +
                "JOIN pacote_turistico p ON r.pacoteId = p.id";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                Reserva reserva = new Reserva();
                reserva.setId(rs.getInt("id"));
                reserva.setDataReserva(rs.getDate("dataReserva"));
                reserva.setStatus(rs.getString("status"));
                reserva.setClienteCpf(rs.getString("clienteCpf"));
                reserva.setPacoteNome(rs.getString("pacoteNome"));

                reservas.add(reserva);
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
        return reservas;
    }
}
