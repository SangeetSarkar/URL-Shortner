import java.sql.*;
import io.github.cdimascio.dotenv.Dotenv;
public class DataManupulation {
    private static final String INSERT_USERS_SQL = "INSERT INTO hashstorage " + "(url) VALUES " + "(?) RETURNING id;";

    Dotenv dotenv = Dotenv.load();

    public int pushData(final String inputurl){

        try(Connection conn = DriverManager.getConnection(dotenv.get("DB_URL"),dotenv.get("DB_USER"),dotenv.get("DB_PASSWORD"));
                PreparedStatement preparedStatement = conn.prepareStatement(INSERT_USERS_SQL)
        ){
            preparedStatement.setString(1,inputurl);

            try(ResultSet rs = preparedStatement.executeQuery()){
                if(rs.next()){
                    int generatedId = rs.getInt("id");
                    System.out.println("Inserted record with id:"+generatedId);
                    return generatedId;
                }
            }
        }catch (SQLException e){
            System.err.println(e.getMessage());
        }

        return -1;
    }
}
