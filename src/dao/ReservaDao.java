package dao;

import db.MyJDBC;
import models.Destino;
import models.Reserva;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ReservaDao {
    public void inserir(Reserva reserva) {
        Connection connection = MyJDBC.getConnection();

        String sql = "INSERT INTO `travel_schema`.`reserva` (`dataReserva`, `status`, `clienteId`, `pacoteId`) VALUES (?, ?, ?, ?)";

        try {

            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setDate(1, reserva.getDataReserva());
            stmt.setString(2, reserva.getStatus());
            stmt.setInt(3, reserva.getClienteId());
            stmt.setInt(4, reserva.getPacoteId());

            stmt.executeUpdate();
            System.out.println("Destino inserido com sucesso!");
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

