public class ConsumerByWaitNotifyDeadlock implements Runnable {

    private final RabbitMq rabbitMq;

    public ConsumerByWaitNotifyDeadlock(RabbitMq rabbitMq) {
        this.rabbitMq = rabbitMq;
    }

    @Override
    public void run() {
        while(true) {
            consume();
        }
    }

    private void consume() {
        String msg;
        while ((msg = rabbitMq.poll()) == null) {
            System.out.println(ThreadUtil.prefixThreadName() + " - Queue is empty - waiting for notification from producers");
            synchronized (rabbitMq) {
                ThreadUtil.waitt(rabbitMq);
            }
        }
        synchronized (rabbitMq) {
            System.out.println(ThreadUtil.prefixThreadName() + " - Message received : " + msg + " - Notify producers");
            ThreadUtil.notifyyAll(rabbitMq);
        }
    }
}
