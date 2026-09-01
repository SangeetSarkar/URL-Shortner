public class Main {
    public static void main(String[] args){
        int strs = 123;

        Encoder en = new Encoder();
        final String encodedString;
        try {
            encodedString = en.encode(strs);
        }catch (IllegalArgumentException e){
            System.err.println("Entered value is not a valid id");
            return;
        }

        Decoder de = new Decoder();

        final int decodedString = de.decode(encodedString);

        System.out.println("Original String: "+strs);
        System.out.println("Encoded-String: "+encodedString);
        System.out.println("Decoded-String: "+decodedString);
    }
}
