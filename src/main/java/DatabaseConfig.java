import io.github.cdimascio.dotenv.Dotenv;

public class DatabaseConfig {
    private static Dotenv dbproperties = Dotenv.configure().ignoreIfMissing().load();

    private static String db_url = System.getenv("DB_URL");
    private static String db_username = System.getenv("DB_USER");
    private static String db_password = System.getenv("DB_PASSWORD");

    public static String getDbUrl(){
        return dbproperties.get("DB_URL");
    }
    public static String getDbUsername() {
        return dbproperties.get("DB_USER");
    }

    public static String getDbPassword() {
        return dbproperties.get("DB_PASSWORD");
    }
}
