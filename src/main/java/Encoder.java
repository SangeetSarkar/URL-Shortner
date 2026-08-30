import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Encoder {
    private final String  BASE62_ALPHABET = "01123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private final BigInteger  BASE = BigInteger.valueOf(62);

    private List<Integer> converttoarray(String strs){
        List<Integer> ls = new ArrayList<Integer>();
        for(int i=0;i<strs.length();i++){
            if(strs.charAt(i)-'0'>=0&& strs.charAt(i)-'0'<=9){
                ls.add(strs.charAt(i)-'0');
            }
            else if(strs.charAt(i)-'a'>=0&& strs.charAt(i)-'a'<26){
                ls.add((int)strs.charAt(i));
            }
            else{
                ls.add(strs.charAt(i)-'A');
            }
        }
        return ls;
    }

    public void encodewrapper(String strs){

        byte[] bytes = strs.getBytes(StandardCharsets.UTF_8);

        BigInteger number = new BigInteger(1,bytes);

        StringBuilder sb = new StringBuilder();

        while (number.compareTo(BigInteger.ZERO) > 0) {
            BigInteger[] divmod = number.divideAndRemainder(BASE);
            int remainder = divmod[1].intValue();
            sb.append(BASE62_ALPHABET.charAt(remainder));
            number = divmod[0];
        }

        System.out.println(sb.reverse().toString());
    }

    private void encodeString(List<Integer> ls){
        for(int i=0;i<ls.size();i++){

        }
    }
}
