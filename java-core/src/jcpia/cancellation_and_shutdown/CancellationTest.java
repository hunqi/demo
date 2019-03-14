package jcpia.cancellation_and_shutdown;

import java.math.BigInteger;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import static java.util.concurrent.TimeUnit.SECONDS;

public class CancellationTest {

    public static void main(String[] args) throws InterruptedException {
        consumePrimes();
    }

    private static BigInteger number = BigInteger.ONE;

    static void consumePrimes() throws InterruptedException {
        BlockingQueue<BigInteger> primes = new LinkedBlockingQueue<>(10);
        BrokenPrimeProducer producer = new BrokenPrimeProducer(primes);
        producer.start();

        SECONDS.sleep(1);
        try {
            while (needMorePrimes()) {
                number = primes.take();
                Thread.sleep(10);
                System.out.print(number + ",");
            }
        } finally {
            System.out.println("To cancel producer:");
            producer.cancel();
        }
    }

    private static boolean needMorePrimes() {
        return BigInteger.valueOf(100).compareTo(number) > 0;
    }

}

class BrokenPrimeProducer extends Thread {

    private final BlockingQueue<BigInteger> queue;
    private volatile boolean cancelled = false;

    BrokenPrimeProducer(BlockingQueue<BigInteger> q) {
        queue = q;
    }

    @Override
    public void run() {
        BigInteger p = BigInteger.ONE;
        while (/*!cancelled*/!Thread.currentThread().isInterrupted()) {
            try {
                queue.put(p = p.nextProbablePrime());
            } catch (InterruptedException e) {
//                e.printStackTrace();
//                System.exit(0);
                interrupt();
            }
        }

        System.out.println("---done---");
    }

    void cancel() {
//        cancelled = true;
        interrupt();
    }
}
