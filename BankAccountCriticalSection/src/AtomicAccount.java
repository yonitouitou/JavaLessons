import java.util.concurrent.atomic.AtomicLong;

public class AtomicAccount {

    private volatile AtomicLong balance;

    public AtomicAccount(long initial) {
        balance = new AtomicLong(initial);
    }

    public synchronized void addCash(long value) {
        balance.addAndGet(value);
        sendSms();
    }

    public synchronized void takeCash(long value) {
        balance.getAndAdd(value * -1);
        sendSms();
    }

    public long getBalance() {
        return balance.longValue();
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
