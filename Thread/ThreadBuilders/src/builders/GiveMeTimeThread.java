package builders;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

public class GiveMeTimeThread extends Thread {

    @Override
    public void run() {
        int i = 0;
        try {
            while(i < 5) {
                System.out.println("[" + Thread.currentThread().getName() + "] The IL time is : " + getTime());
                TimeUnit.SECONDS.sleep(5);
                i++;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private String getTime() {
        return LocalTime.now().format(DateTimeFormatter.ISO_LOCAL_TIME);
    }
}
