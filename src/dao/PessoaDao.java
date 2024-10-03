package dao;

import db.MyJDBC;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import models.Pessoa;

public class PessoaDao {

    public void inserir(Pessoa pessoa) {
        Connection connection = MyJDBC.getConnection();

        String sql = "INSERT INTO pessoa (id, nome, email, telefone) VALUES (?, ?, ?, ?)";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, pessoa.getId());
            stmt.setString(2, pessoa.getNome());
            stmt.setString(3, pessoa.getEmail());
            stmt.setString(4, pessoa.getTelefone());

            stmt.executeUpdate();
            System.out.println("Pessoa inserida com sucesso!");
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
