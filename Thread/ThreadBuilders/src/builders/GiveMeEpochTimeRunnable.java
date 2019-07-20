package builders;

import java.util.concurrent.TimeUnit;

public class GiveMeEpochTimeRunnable implements Runnable {

    @Override
    public void run() {
        int i = 0;
        try {
            while(i < 5) {
                System.out.println("[" + Thread.currentThread().getName() + "] The epoch time is : " + System.currentTimeMillis());
                TimeUnit.SECONDS.sleep(5);
                i++;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
