public class SynchronizedAccount2 {

    private volatile long balance;

    public SynchronizedAccount2(long initial) {
        balance = initial;
    }

    public void addCash(long value) {
        synchronized (this) {
            balance = balance + value;
        }
        sendSms();
    }

    public void takeCash(long value) {
        synchronized (this) {
            balance = balance - value;
        }
        sendSms();
    }

    public long getBalance() {
        synchronized (this) {
            return balance;
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
