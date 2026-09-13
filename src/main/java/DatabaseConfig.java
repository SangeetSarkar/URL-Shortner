    import io.github.cdimascio.dotenv.Dotenv;

public class DatabaseConfig {
    private static final Dotenv dbproperties = Dotenv.load();

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
