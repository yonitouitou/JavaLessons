public class ProducerConsumerThreads {

    public static void main(String[] args) {
        //runWithSleepAlgo();
        runWithWaitNotifyAlgo();
        //runWithWaitNotifyDeadlock();
    }

    private static void runWithSleepAlgo() {
        RabbitMq rabbitMq = new RabbitMq();
        Thread producer = new Thread(new ProducerBySleepRunnable(rabbitMq), "Producer1");
        Thread consumer = new Thread(new ConsumerBySleepRunnable(rabbitMq), "Consumer1");
        producer.start();
        consumer.start();
    }

    private static void runWithWaitNotifyAlgo() {
        RabbitMq rabbitMq = new RabbitMq();
        Thread producer = new Thread(new ProducerByWaitNotify(rabbitMq), "Producer2");
        Thread consumer = new Thread(new ConsumerByWaitNotify(rabbitMq), "Consumer2");
        producer.start();
        consumer.start();
    }

    private static void runWithWaitNotifyDeadlock() {
        RabbitMq rabbitMq = new RabbitMq();
        Thread producer = new Thread(new ProducerByWaitNotifyDeadlock(rabbitMq), "Producer3");
        Thread consumer = new Thread(new ConsumerByWaitNotifyDeadlock(rabbitMq), "Consumer3");
        producer.start();
        consumer.start();
    }
}
