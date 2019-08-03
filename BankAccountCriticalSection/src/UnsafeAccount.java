public class UnsafeAccount {

    private long balance;

    public UnsafeAccount(long initial) {
        balance = initial;
    }

    public void addCash(long value) {
        balance = balance + value;
        sendSms();
    }

    public void takeCash(long value) {
        balance = balance - value;
        sendSms();
    }

    public long getBalance() {
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
