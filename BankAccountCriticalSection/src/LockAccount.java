import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockAccount {

    private volatile long balance;
    private final Lock lock = new ReentrantLock(true);

    public LockAccount(long initial) {
        balance = initial;
    }

    public void addCash(long value) {
        try {
            lock.lock();
            balance = balance + value;
        } finally {
            lock.unlock();
        }
        sendSms();
    }

    public void takeCash(long value) {
        try {
            lock.lock();
            balance = balance - value;
        } finally {
            lock.unlock();
        }
        sendSms();
    }

    public long getBalance() {
        try {
            lock.lock();
            return balance;
        } finally {
            lock.unlock();
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
