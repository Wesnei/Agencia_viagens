import java.sql.*;

public class MyJDBC {
    public static void main(String[] args) {
        try{
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3306/travel_schema",
                    "root",
                    "9ZDTCpt6@"
            );

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM `travel_schema`.`pessoa`");

            while (resultSet.next()) {
                System.out.println(resultSet.getString("id"));
                System.out.println(resultSet.getString("nome"));
                System.out.println(resultSet.getString("email"));
                System.out.println(resultSet.getString("telefone"));
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

