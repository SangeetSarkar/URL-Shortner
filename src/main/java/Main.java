public class Main {
    public static void main(String[] args){

        DbConnection conn = new DbConnection();
        conn.connectDB();

        DataManupulation dm = new DataManupulation();

        int id = dm.pushData("https://us.com");

        /*dm.pushData(args[0]);*/

        Encoder en = new Encoder();
        Decoder de = new Decoder();

        System.out.println("Original: "+id);
        System.out.println("Encoded: "+en.encode(4000+id));
        System.out.println("Decoded: "+de.decode(en.encode(4000+id)));

    }
}
