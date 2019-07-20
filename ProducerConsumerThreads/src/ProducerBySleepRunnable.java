import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

public class ProducerBySleepRunnable implements Runnable {

    private static final ThreadLocalRandom RANDOM = ThreadLocalRandom.current();
    private RabbitMq rabbitMq;

    public ProducerBySleepRunnable(RabbitMq rabbitMq) {
        this.rabbitMq = rabbitMq;
    }
    @Override
    public void run() {
        while(true) {
            String msg = UUID.randomUUID().toString();
            boolean isInserted = rabbitMq.offer(msg);
            if (isInserted) {
                System.out.println(ThreadUtil.prefixThreadName() + " - Message inserted : " + msg);
                ThreadUtil.sleep(RANDOM.nextLong(1000, 3000));
            } else {
                long waitTime = RANDOM.nextLong(5000, 6000);
                System.out.println(ThreadUtil.prefixThreadName() + " - Queue full - waiting " + waitTime + " milliseconds before retry");
                ThreadUtil.sleep(waitTime);
            }
        }
    }
}
