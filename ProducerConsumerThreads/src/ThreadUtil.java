public final class ThreadUtil {

    public static String prefixThreadName() {
        return "[" + Thread.currentThread().getName() + "]";
    }


    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void notifyyAll(Object lock) {
        lock.notifyAll();
    }

    public static void waitt(Object lock) {
        try {
            lock.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
