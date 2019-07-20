public class NonThreadSafeDBConnection {

    private static NonThreadSafeDBConnection INSTANCE;
    private final String mysqlConnectionString;

    private NonThreadSafeDBConnection() {
        mysqlConnectionString = "Init my connection - heavy-weight operations";
    }

    public static NonThreadSafeDBConnection getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new NonThreadSafeDBConnection();
        }
        return INSTANCE;
    }
}
