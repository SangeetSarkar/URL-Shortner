import io.github.cdimascio.dotenv.Dotenv;

public class RedisConfig {
    private static final Dotenv redisproperties = Dotenv.configure().ignoreIfMissing().load();

    public static String getRedisUrl(){
        return redisproperties.get("REDIS_URL");
    }

    public static String getRedisusername() {
        return redisproperties.get("REDIS_USERNAME");
    }

    public static String getRedisPassword() {
        return redisproperties.get("REDIS_PASSWORD");
    }
}
