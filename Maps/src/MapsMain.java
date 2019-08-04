import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class MapsMain {

    public static void main(String[] args) throws InterruptedException {
        updateMapFromSeveralThreads(new HashMap<>());
        updateMapFromSeveralThreads(Collections.synchronizedMap(new HashMap<>()));
        updateMapFromSeveralThreads(new ConcurrentHashMap());
    }

    private static void updateMapFromSeveralThreads(Map<String, String> map) throws InterruptedException {
        Runnable r = () -> {
            int i = 0;
            while (i++ < 10000) {
                map.put(UUID.randomUUID().toString(), String.valueOf(System.currentTimeMillis()));
            }
        };

        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);
        Thread t3 = new Thread(r);
        t1.start();
        t2.start();
        t3.start();
        t1.join();
        t2.join();
        t3.join();
        System.out.println(map.getClass().getSimpleName() + " size : " + map.size());
    }
}
