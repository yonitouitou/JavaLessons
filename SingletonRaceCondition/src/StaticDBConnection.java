public class StaticDBConnection {

    private static StaticDBConnection INSTANCE = new StaticDBConnection();
    private final String mysqlConnectionString;

    private StaticDBConnection() {
        mysqlConnectionString = "Init my connection - heavy-weight operations";
    }

    public static StaticDBConnection getInstance() {
        return INSTANCE;
    }
}
