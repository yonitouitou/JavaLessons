public class SynchronizedDBConnection {

    private static final Object LOCK = new Object();
    private static SynchronizedDBConnection INSTANCE;
    private final String mysqlConnectionString;

    private SynchronizedDBConnection() {
        mysqlConnectionString = "Init my connection - heavy-weight operations";
    }

    public static SynchronizedDBConnection getInstance() {
        synchronized (LOCK) {
            if (INSTANCE == null) {
                INSTANCE = new SynchronizedDBConnection();
            }
        }
        return INSTANCE;
    }
}
