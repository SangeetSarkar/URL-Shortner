import java.sql.*;

public class PushURL_DB {
    private static final String INSERT_USERS_SQL = "INSERT INTO hashstorage (url) VALUES " + "(?) RETURNING id;";

    public int pushData(final String inputurl){

        try(Connection conn = DB.connect();
                PreparedStatement preparedStatement
                        = conn.prepareStatement(INSERT_USERS_SQL)
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
