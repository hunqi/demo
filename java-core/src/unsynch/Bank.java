package unsynch;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Bank {

    //    private Lock bankLock;
//    private Condition sufficientFunds;
    private final double[] accounts;


    public Bank(int n, double initBalance) {
        accounts = new double[n];
        for (int i = 0; i < accounts.length; i++) {
            accounts[i] = initBalance;
        }
//        bankLock = new ReentrantLock();
//        sufficientFunds = bankLock.newCondition();
    }

    public synchronized void transfer(int from, int to, double amount) throws InterruptedException {
//        bankLock.lock();
//        try {

        while (accounts[from] < amount)
            wait();
//                sufficientFunds.await();
        System.out.println(Thread.currentThread());
        accounts[from] -= amount;
        System.out.printf("%10.2f from %d to %d,", amount, from, to);
        accounts[to] += amount;
        System.out.printf("Total balance: %10.2f%n", getTotalBalance());
//            sufficientFunds.signalAll();
        notifyAll();
//        } finally {
//            bankLock.unlock();
//        }
    }

    private synchronized double getTotalBalance() {
//        bankLock.lock();
//        try {
        double sum = 0;
        for (double a : accounts)
            sum += a;
        return sum;
//        } finally {
//            bankLock.unlock();
//        }
    }

    public int size() {
        return accounts.length;
    }

}
