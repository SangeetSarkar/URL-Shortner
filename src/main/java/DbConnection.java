import java.sql.*;
import java.util.Arrays;
import java.util.Properties;

public class DbConnection {
    void connectDB(){
        final String url = "jdbc:postgresql://65.0.170.126:5432/urlshortner";
        final Properties props = new Properties();
        props.setProperty("user", "urlshortner");
        props.setProperty("password","root");

        try (Connection conn = DriverManager.getConnection(url, props)) {
            System.out.println("Connected to DB");
        } catch(SQLException e) {
            System.out.println("Error connecting to database " + e.getMessage());
        }
    }
}
