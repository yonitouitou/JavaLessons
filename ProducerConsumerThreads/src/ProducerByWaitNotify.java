import java.util.UUID;

public class ProducerByWaitNotify implements Runnable {

    private final RabbitMq rabbitMq;

    public ProducerByWaitNotify(RabbitMq rabbitMq) {
        this.rabbitMq = rabbitMq;
    }

    @Override
    public void run() {
        while(true) {
            produce();
        }
    }

    private void produce() {
        String msg = UUID.randomUUID().toString();
        synchronized (rabbitMq) {
            while (!rabbitMq.offer(msg)) {
                System.out.println(ThreadUtil.prefixThreadName() + " - Queue full - waiting for a notification from consumers...");
                ThreadUtil.waitt(rabbitMq);
            }
            System.out.println(ThreadUtil.prefixThreadName() + " - Message inserted : " + msg + " - Notify consumers");
            ThreadUtil.notifyyAll(rabbitMq);
        }
    }
}
