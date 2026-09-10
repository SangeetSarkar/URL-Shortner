public class Main {
    public static void main(String[] args){

        DbConnection conn = new DbConnection();
        conn.connectDB();

        PushURL_DB datapusher = new PushURL_DB();

        int id = datapusher.pushData("https://India.com");

        Encoder en = new Encoder();
        Decoder de = new Decoder();

        System.out.println("Original URL: "+id);
        System.out.println("EncodedURL : https://tinyurl.com/"+en.encode(id));
        System.out.println("Decoded: "+de.decode(en.encode(id)));

    }
}
