public class ThreadActions {

    private static Thread t1;
    private static Thread t2;
    private static Thread t3;

    public static void main(String[] args) throws InterruptedException {

        t1 = new Thread(new RunnableCounter(1, 10));
        t2 = new Thread(new RunnableCounter(11, 20));
        t3 = new Thread(new RunnableCounter(21, 30));

        concurrentExecution();
        serialExecution();
    }

    private static void concurrentExecution() {
        t1.start();
        t2.start();
        t3.start();
    }

    private static void serialExecution() throws InterruptedException {
        t1.start();
        t1.join();
        t2.start();
        t2.join();
        t3.start();
        t3.join();
    }
}
