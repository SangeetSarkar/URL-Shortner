import java.sql.*;

public class PushURL_DB {
    private static final String INSERT_USERS_SQL = "INSERT INTO hashstorage (short_code,long_url) VALUES (?,?) returning short_code;";

    public static void pushData(final String inputurl){
        if(RedisCache.checkInRedis(inputurl)){
            System.out.println(RedisCache.getRedisData(inputurl));
            return;
        }
        RedisCache.store(inputurl);
        dataPusherImpl(inputurl);
    }

    private static void dataPusherImpl(String inputurl){
        try(Connection conn = DB.connect();
            PreparedStatement preparedStatement
                    = conn.prepareStatement(INSERT_USERS_SQL)
        ){
            preparedStatement.setString(1,Base62_encoder.encode(inputurl));
            preparedStatement.setString(2,inputurl);

            try(ResultSet rs = preparedStatement.executeQuery()){
                if(rs.next()){
                    String generatedId = rs.getString("short_code");
                    System.out.println("Inserted into DB with id: "+generatedId);
                }
            }
        }catch (SQLException e){
            System.err.println(e.getMessage());
        }
    }
}
