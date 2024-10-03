package dao;

import db.MyJDBC;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import models.Pessoa;

public class PessoaDao {

    public void inserir(Pessoa pessoa) {
        Connection connection = MyJDBC.getConnection();

        String sql = "INSERT INTO `travel_schema`.`pessoa` (`nome`, `email`, `telefone`) VALUES (?, ?, ?)";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            stmt.setString(1, pessoa.getNome());
            stmt.setString(2, pessoa.getEmail());
            stmt.setString(3, pessoa.getTelefone());

            stmt.executeUpdate();
            System.out.println("Pessoa inserida com sucesso!");
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                int generatedId = rs.getInt(1);
                pessoa.setId(generatedId);
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
}
