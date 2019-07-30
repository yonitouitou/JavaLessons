public class DoubleCheckedDBConnection {

    private static final Object LOCK = new Object();
    private static volatile DoubleCheckedDBConnection INSTANCE;
    private final String mysqlConnectionString;

    private DoubleCheckedDBConnection() {
        mysqlConnectionString = "Init my connection - heavy-weight operations";
    }

    public static DoubleCheckedDBConnection getInstance() {
        if (INSTANCE != null) {
            synchronized (LOCK) {
                if (INSTANCE == null) {
                    INSTANCE = new DoubleCheckedDBConnection();
                }
            }
        }
        return INSTANCE;
    }
}
