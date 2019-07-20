import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;

public class RabbitMq {

    private static final long MAX_CAPACITY = 1;
    // AtomicLong instead of long to avoid race condition since we read and write the value with different threads.
    private volatile AtomicLong size = new AtomicLong(0);
    private Queue<String> queue = new LinkedList<>();

    public boolean offer(String s) {
        boolean isInserted;
        if (size.get() < MAX_CAPACITY) {
            queue.offer(s);
            size.incrementAndGet();
            isInserted = true;
        } else {
            isInserted = false;
        }
        return isInserted;
    }

    public String poll() {
        String msg = queue.poll();
        if (msg != null) {
            size.decrementAndGet();
        }
        return msg;
    }
}
