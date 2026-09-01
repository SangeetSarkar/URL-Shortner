public class Encoder {
    private final String  BASE62_ALPHABET = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public String encode(int num){
        StringBuilder sb = new StringBuilder();
        while(num!=0){
            sb.insert(0,BASE62_ALPHABET.charAt(num%62));
            num/=62;
        }
        return sb.toString();
    }
}
