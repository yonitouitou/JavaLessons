public class NonSafetyAccount {

    private long balance = 0;

    public void push(long value) {
        balance = balance + value;
    }

    public void poll(long value) {
        balance = balance - value;
    }

    public long getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "NonSafetyAccount{" +
                "balance=" + balance +
                '}';
    }
}
