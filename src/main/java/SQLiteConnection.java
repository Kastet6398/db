import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SQLiteConnection {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://ep-twilight-cherry-a257ysci.eu-central-1.aws.neon.tech/example?sslmode=require";
        String username = "konsta.ntinnezhalsky";
        String password = "sm27ngkjIbxt";


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
