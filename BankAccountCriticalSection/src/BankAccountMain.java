public class BankAccountMain {

    public static void main(String[] args) throws InterruptedException {
        unsafeBankAccount();
        synchronizedBankAccount();
        synchronizedBankAccount2();
        lockBankAccount();
        semaphoreBankAccount();
        atomicBankAccount();
    }

    private static void unsafeBankAccount() throws InterruptedException {
        UnsafeAccount account = new UnsafeAccount(100);

        Runnable r1 = () -> {
            int i = 0;
            while (i++ < 10000) {
                account.addCash(10);
            }
        };

        Runnable r2 = () -> {
            int i = 0;
            while (i++ < 10000) {
                account.takeCash(10);
            }
        };
        start2Threads(r1, r2);
        System.out.println("Balance : " + account.getBalance());
    }

    private static void synchronizedBankAccount() throws InterruptedException {
        SynchronizedAccount account = new SynchronizedAccount(100);

        Runnable r1 = () -> {
            int i = 0;
            while (i++ < 10000) {
                account.addCash(10);
            }
        };

        Runnable r2 = () -> {
            int i = 0;
            while (i++ < 10000) {
                account.takeCash(10);
            }
        };
        start2Threads(r1, r2);
        System.out.println("Balance : " + account.getBalance());
    }

    private static void synchronizedBankAccount2() throws InterruptedException {
        SynchronizedAccount2 account = new SynchronizedAccount2(100);

        Runnable r1 = () -> {
            int i = 0;
            while (i++ < 10000) {
                account.addCash(10);
            }
        };

        Runnable r2 = () -> {
            int i = 0;
            while (i++ < 10000) {
                account.takeCash(10);
            }
        };
        start2Threads(r1, r2);
        System.out.println("Balance : " + account.getBalance());
    }

    private static void lockBankAccount() throws InterruptedException {
        LockAccount account = new LockAccount(100);

        Runnable r1 = () -> {
            int i = 0;
            while (i++ < 10000) {
                account.addCash(10);
            }
        };

        Runnable r2 = () -> {
            int i = 0;
            while (i++ < 10000) {
                account.takeCash(10);
            }
        };
        start2Threads(r1, r2);
        System.out.println("Balance : " + account.getBalance());
    }

    private static void semaphoreBankAccount() throws InterruptedException {
        SemaphoreAccount account = new SemaphoreAccount(100);

        Runnable r1 = () -> {
            int i = 0;
            try {
                while (i++ < 10000) {
                    account.addCash(10);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Runnable r2 = () -> {
            int i = 0;
            try {
                while (i++ < 10000) {
                    account.takeCash(10);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        start2Threads(r1, r2);
        System.out.println("Balance : " + account.getBalance());
    }


    private static void atomicBankAccount() throws InterruptedException {
        AtomicAccount account = new AtomicAccount(100);

        Runnable r1 = () -> {
            int i = 0;
            while (i++ < 10000) {
                account.addCash(10);
            }
        };

        Runnable r2 = () -> {
            int i = 0;
            while (i++ < 10000) {
                account.takeCash(10);
            }
        };
        start2Threads(r1, r2);
        System.out.println("Balance : " + account.getBalance());
    }

    private static void start2Threads(Runnable r1, Runnable r2) throws InterruptedException {
        Thread user1 = new Thread(r1);
        Thread user2 = new Thread(r2);
        user1.start();
        user2.start();
        user1.join();
        user2.join();
    }
}
