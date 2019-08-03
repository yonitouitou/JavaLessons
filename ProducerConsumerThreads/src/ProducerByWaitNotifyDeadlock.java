import java.util.UUID;

public class ProducerByWaitNotifyDeadlock implements Runnable {

    private final RabbitMq rabbitMq;

    public ProducerByWaitNotifyDeadlock(RabbitMq rabbitMq) {
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
        while (!rabbitMq.offer(msg)) {
            System.out.println(ThreadUtil.prefixThreadName() + " - Queue full - waiting for a notification from consumers...");
            synchronized (rabbitMq) {
                ThreadUtil.waitt(rabbitMq);
            }
        }
        synchronized (rabbitMq) {
            System.out.println(ThreadUtil.prefixThreadName() + " - Message inserted : " + msg + " - Notify consumers");
            ThreadUtil.notifyyAll(rabbitMq);
        }
    }
}
