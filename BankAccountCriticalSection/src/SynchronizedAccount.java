public class SynchronizedAccount {

    private volatile long balance;

    public SynchronizedAccount(long initial) {
        balance = initial;
    }

    public synchronized void addCash(long value) {
        balance = balance + value;
        sendSms();
    }

    public synchronized void takeCash(long value) {
        balance = balance - value;
        sendSms();
    }

    public synchronized long getBalance() {
        return balance;
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
