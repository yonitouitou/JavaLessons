import builders.GiveMeEpochTimeRunnable;
import builders.GiveMeTimeThread;

import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class ThreadBuilders {

    public static void main(String[] args) {
        //byThreadClass();
        //byRunnableInterface();
        //byLambdaExpression();
        //byAnonymousClass();
    }

    private static void byThreadClass() {
        GiveMeTimeThread thread = new GiveMeTimeThread();
        thread.start();
        System.out.println("GiveMeTimeThread is running...");
    }

    private static void byRunnableInterface() {
        Thread t = new Thread(new GiveMeEpochTimeRunnable());
        t.start();
        System.out.println("GiveMeEpochTimeRunnable is running...");
    }

    private static void byLambdaExpression() {
        Runnable r = () -> {
            int i = 0;
            while (i < 5) {
                String nyTime = LocalTime.now(ZoneId.of("America/New_York")).format(DateTimeFormatter.ISO_LOCAL_TIME);
                System.out.println("[" + Thread.currentThread().getName() + "] The NY time is : " + nyTime);
                ThreadUtil.sleep(5000);
                i++;
            }
        };
        new Thread(r, "MyThread").start();
    }

    private static void byAnonymousClass() {
        new Thread() {
            @Override
            public void run() {
                int i = 0;
                while (i < 5) {
                    String londonTime = LocalTime.now(ZoneId.of("Europe/London")).format(DateTimeFormatter.ISO_LOCAL_TIME);
                    System.out.println("[" + Thread.currentThread().getName() + "] The London time is : " + londonTime);
                    ThreadUtil.sleep(5000);
                    i++;
                }
            }
        }.start();
    }

}
