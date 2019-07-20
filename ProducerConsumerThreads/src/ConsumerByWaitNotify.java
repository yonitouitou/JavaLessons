public class ConsumerByWaitNotify implements Runnable {

    private final RabbitMq rabbitMq;

    public ConsumerByWaitNotify(RabbitMq rabbitMq) {
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
        synchronized (rabbitMq) {
            while ((msg = rabbitMq.poll()) == null) {
                System.out.println(ThreadUtil.prefixThreadName() + " - Queue is empty - waiting for notification from producers");
                ThreadUtil.waitt(rabbitMq);
            }
            System.out.println(ThreadUtil.prefixThreadName() + " - Message received : " + msg + " - Notify producers");
            ThreadUtil.notifyy(rabbitMq);
        }
    }
}
