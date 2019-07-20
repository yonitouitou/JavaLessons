public class RunnableCounter implements Runnable {

    private int from;
    private int to;

    public RunnableCounter(int from, int to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public void run() {
        for (int i = from; i <= to; i++) {
            System.out.println(prefixThreadName() + " : " + i);
            if (i < to) {
                sleep(1000);
            }
        }
        System.out.println(prefixThreadName() + "Execution finished");
    }

    private String prefixThreadName() {
        return "[" + Thread.currentThread().getName() + "]";
    }

    private static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
