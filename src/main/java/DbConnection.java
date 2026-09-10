import java.sql.*;
import java.util.Arrays;
import java.util.Properties;

public class DbConnection {
    void connectDB(){
        final String url = DatabaseConfig.getDbUrl();
        final Properties props = new Properties();
        props.setProperty("user", DatabaseConfig.getDbUsername());
        props.setProperty("password",DatabaseConfig.getDbPassword());

        try (Connection conn = DriverManager.getConnection(url, props)) {
            System.out.println("Connected to DB");
        } catch(SQLException e) {
            System.out.println("Error connecting to database " + e.getMessage());
        }
    }
}
