import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Base62_encoder {
    private static final String BASE62 = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static String encode(final String url){

        MessageDigest digest = null;
        try {
            digest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            System.out.println(e.getMessage());
            return "";
        }
        byte[] byte_array = digest.digest(url.getBytes(StandardCharsets.UTF_8));

        return encoderImplementation(byte_array);
    }

    private static String encoderImplementation(byte[] hash){
        long value=0;
        for(int i=0;i<8;i++){
            value = (value<<8) | (hash[i] & 0xFF);
        }
        value = value & Long.MAX_VALUE;

        return long_base62(value);
    }

    private static String long_base62(long value){
        StringBuilder sb = new StringBuilder();
        while (value > 0) {
            int remainder = (int) (value % 62);
            sb.append(BASE62.charAt(remainder));
            value /= 62;
        }

        String base62String = sb.reverse().toString();

        if (base62String.length() < 7) {
            return String.format("%-7s", base62String).replace(' ', '0');
        }
        return base62String.substring(0, 7);
    }
}
