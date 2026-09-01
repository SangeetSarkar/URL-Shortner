public class Decoder {
    private final String  BASE62_ALPHABET = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public int decode(String strs){
        int places=1;
        int decodedString=0;
        for(int i=strs.length()-1;i>=0;i--){
            decodedString+=places*BASE62_ALPHABET.indexOf(strs.charAt(i));
            places*=62;
        }
        return decodedString;
    }
}
