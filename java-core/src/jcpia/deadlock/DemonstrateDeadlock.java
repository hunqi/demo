package jcpia.deadlock;

import java.util.Random;

public class DemonstrateDeadlock {
    private static final int NUM_THREADS = 20;
    private static final int NUM_ACCOUNTS = 5;
    private static final int NUM_ITERATIONS = 1000000;
    private static final Object tieLock = new Object();

    public static void main(String[] args) {
        final Random rnd = new Random();
        final Account[] accounts = new Account[NUM_ACCOUNTS];

        for (int i = 0; i < accounts.length; i++)
            accounts[i] = new Account();

        class TransferThread extends Thread {
            @Override
            public void run() {
                for (int i = 0; i < NUM_ITERATIONS; i++) {
                    int fromAcct = rnd.nextInt(NUM_ACCOUNTS);
                    int toAcct = rnd.nextInt(NUM_ACCOUNTS);
                    DollarAmount amount = new DollarAmount(rnd.nextInt(1000));
                    transferMoney(accounts[fromAcct], accounts[toAcct], amount);
                }
            }

            public void transferMoney(final Account fromAcct,
                                      final Account toAcct,
                                      final DollarAmount amount) {
                class Helper {
                    public void transfer() {
                        if (fromAcct.getBalance().compareTo(amount) < 0) {
//                            throw new InsufficientFundsException();
                            System.out.println("Insufficient balance.");
                        } else {
                            fromAcct.debit(amount);
                            toAcct.credit(amount);
                        }
                    }
                }
                int fromHash = System.identityHashCode(fromAcct);
                int toHash = System.identityHashCode(toAcct);

                if (fromHash < toHash) {
                    synchronized (fromAcct) {
                        synchronized (toAcct) {
                            new Helper().transfer();
                        }
                    }
                } else if (fromHash > toHash) {
                    synchronized (toAcct) {
                        synchronized (fromAcct) {
                            new Helper().transfer();
                        }
                    }
                } else {
                    synchronized (tieLock) {
                        synchronized (fromAcct) {
                            synchronized (toAcct) {
                                new Helper().transfer();
                            }
                        }
                    }
                }
            }
        }

        for (int i = 0; i < NUM_THREADS; i++) {
            new TransferThread().start();
        }

    }

}

class Account {
    private int bankcardNumber;
    private DollarAmount balance;

    public Account() {
        balance = new DollarAmount(1000);
    }

    public Account(int bankcardNumber) {
        this.bankcardNumber = bankcardNumber;
    }

    public int getBankcardNumber() {
        return bankcardNumber;
    }

    public void setBankcardNumber(int bankcardNumber) {
        this.bankcardNumber = bankcardNumber;
    }

    public DollarAmount getBalance() {
        return balance;
    }

    public void setBalance(DollarAmount balance) {
        this.balance = balance;
    }

    public void debit(DollarAmount amount) {
        balance.setAmount(balance.getAmount() - amount.getAmount());
    }

    public void credit(DollarAmount amount) {
        balance.setAmount(balance.getAmount() + amount.getAmount());
    }
}

class DollarAmount implements Comparable<DollarAmount> {
    private int amount;

    public DollarAmount(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public int compareTo(DollarAmount o) {
        return this.amount - o.amount;
    }
}

class InsufficientFundsException extends RuntimeException {
}
