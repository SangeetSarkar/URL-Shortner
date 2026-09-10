import java.sql.*;

public class Decoder {
    private final String  BASE62_ALPHABET = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public String decode(String strs){
        int places=1;
        int decodedIndex=0;
        for(int i=strs.length()-1;i>=0;i--){
            decodedIndex+=places*BASE62_ALPHABET.indexOf(strs.charAt(i));
            places*=62;
        }
        return getOriginalURLfromIndex(decodedIndex);
    }

    private String getOriginalURLfromIndex(int decodedIndex){
        final String QUERY_STATEMENT = createQueryStatement(decodedIndex);
        try(Connection conn = DB.connect();
            PreparedStatement preparedStatement = conn.prepareStatement(QUERY_STATEMENT);){
            try(ResultSet res = preparedStatement.executeQuery()){
                if(res.next()){
                    return res.getString("url");

                }
            }
        }catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return "";
    }

    private String createQueryStatement(int id){
        StringBuilder res =new StringBuilder("SELECT * FROM hashstorage where id = ");
        res.append(id);
        res.append(';');

        return res.toString();
    }
}
