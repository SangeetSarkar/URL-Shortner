public class Encoder {
    private final String  BASE62_ALPHABET = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public void myencoder(int num){
        StringBuilder sb = new StringBuilder();
        while(num!=0){
            sb.insert(0,BASE62_ALPHABET.charAt(num%62));
            num/=62;
        }
        System.out.println(sb);
    }

    public void mydecoder(String strs){
        int places=1;
        int decodedString=0;
        for(int i=strs.length()-1;i>=0;i--){
            decodedString+=places*BASE62_ALPHABET.indexOf(strs.charAt(i));
            places*=62;
        }
        System.out.println("Decoded String: "+decodedString);
    }

    void myprint(byte[] bytes){
        for(int i =0;i<bytes.length;i++){
            System.out.print(bytes[i]+"/");
        }
    }

    public void main(){
        myencoder(12345);
        mydecoder("3d7");
    }
}
