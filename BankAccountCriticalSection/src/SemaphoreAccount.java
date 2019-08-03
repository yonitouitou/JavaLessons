import java.util.concurrent.Semaphore;

public class SemaphoreAccount {

    private volatile long balance;
    private final Semaphore semaphore = new Semaphore(1);

    public SemaphoreAccount(long initial) {
        balance = initial;
    }

    public void addCash(long value) throws InterruptedException {
        try {
            semaphore.acquire();
            balance = balance + value;
        } finally {
            semaphore.release();
        }
        sendSms();
    }

    public void takeCash(long value) throws InterruptedException {
        try {
            semaphore.acquire();
            balance = balance - value;
        } finally {
            semaphore.release();
        }
        sendSms();
    }

    public long getBalance() throws InterruptedException {
        try {
            semaphore.acquire();
            return balance;
        } finally {
            semaphore.release();
        }
    }

    private void sendSms() {
        // Send SMS when balance is updated
    }

    @Override
    public String toString() {
        return "NonSafetyAccount{" +
                "balance=" + balance +
                '}';
    }
}
