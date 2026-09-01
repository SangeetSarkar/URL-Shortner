public class Main {
    public static void main(String[] args){
        int strs =12345;

        Encoder en = new Encoder();

        final String encodedString = en.encode(strs);

        Decoder de = new Decoder();

        final int decodedString = de.decode(encodedString);
        System.out.println("Original String: "+strs);
        System.out.println("Encoded-String: "+encodedString);
        System.out.println("Decoded-String: "+decodedString);
    }
}
