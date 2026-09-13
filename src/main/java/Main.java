public class Main {
    public static void main(String[] args){
        String url = "https://example.com/products/electronics/laptops/2026-model?ref=twitter_campaign";

        System.out.println(Base62_encoder.encode(url));
    }
}
