import io.github.cdimascio.dotenv.Dotenv;
import io.lettuce.core.*;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.sync.RedisCommands;

public class RedisCache {
    public static void store(String url) {
        RedisURI uri = RedisURI.Builder
                .redis(RedisConfig.getRedisUrl(), 6379)
                .withAuthentication(RedisConfig.getRedisusername(),RedisConfig.getRedisPassword())
                .build();

        try(RedisClient client = RedisClient.create(uri);
        StatefulRedisConnection<String, String> connection = client.connect()) {
            RedisCommands<String, String> commands = connection.sync();
            commands.set(url,Base62_encoder.encode(url));

        }catch (Exception e){
            System.err.println(e.getMessage());
        }

    }
    public static boolean checkInRedis(String url){
        RedisURI uri = RedisURI.Builder
                .redis(RedisConfig.getRedisUrl(), 6379)
                .withAuthentication(RedisConfig.getRedisusername(),RedisConfig.getRedisPassword())
                .build();

        try(RedisClient client = RedisClient.create(uri);
            StatefulRedisConnection<String, String> connection = client.connect()) {
            RedisCommands<String, String> commands = connection.sync();
            String result = commands.get(url);
            if(result==null){
                System.out.println("No Data found in Redis");
                return false;
            }
            System.out.println(result);
            return true;

        }catch (Exception e){
            System.err.println(e.getMessage());
            return false;
        }
    }
    public static String getRedisData(String url){
        RedisURI uri = RedisURI.Builder
                .redis(RedisConfig.getRedisUrl(), 6379)
                .withAuthentication(RedisConfig.getRedisusername(),RedisConfig.getRedisPassword())
                .build();

        try(RedisClient client = RedisClient.create(uri);
            StatefulRedisConnection<String, String> connection = client.connect()) {
            RedisCommands<String, String> commands = connection.sync();
            return commands.get(url);

        }catch (Exception e){
            System.err.println(e.getMessage());
            return null;
        }
    }
}
