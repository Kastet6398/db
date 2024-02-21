import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Db {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://127.0.0.1:5433/postgres";
        String username = "postgres";
        String password = "password";


        try {
            Class.forName("org.postgresql.Driver");

            Connection connection = DriverManager.getConnection(url, username, password);


            connection.createStatement().executeUpdate("DROP TABLE IF EXISTS tb");
            connection.createStatement().executeUpdate("CREATE TABLE IF NOT EXISTS tb (id SERIAL PRIMARY KEY, text TEXT)");
            connection.createStatement().executeUpdate("DELETE FROM tb");
            connection.createStatement().executeUpdate("INSERT INTO tb(text) VALUES ('fff')");
            connection.createStatement().executeUpdate("UPDATE tb SET text = 'ggg' WHERE id=1");
            ResultSet rs = connection.createStatement().executeQuery("SELECT * FROM tb;");
            while (rs.next()) {
                System.out.println(rs.getString("text"));
            }
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
