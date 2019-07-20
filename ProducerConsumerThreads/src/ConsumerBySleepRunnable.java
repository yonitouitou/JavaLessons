import java.util.concurrent.ThreadLocalRandom;

public class ConsumerBySleepRunnable implements Runnable {

    private static final ThreadLocalRandom RANDOM = ThreadLocalRandom.current();
    private RabbitMq rabbitMq;

    public ConsumerBySleepRunnable(RabbitMq rabbitMq) {
        this.rabbitMq = rabbitMq;
    }

    @Override
    public void run() {
        while(true) {
            String msg = rabbitMq.poll();
            if (msg == null) {
                long waitTime = RANDOM.nextLong(4000, 6000);
                System.out.println(ThreadUtil.prefixThreadName() + " - Queue is empty - waiting " + waitTime + " milliseconds");
                ThreadUtil.sleep(waitTime);
            } else {
                System.out.println(ThreadUtil.prefixThreadName() + " - Message received : " + msg);
                ThreadUtil.sleep(RANDOM.nextLong(2000, 5000));
            }
        }
    }
}
