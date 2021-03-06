package jcpia.synchronizer;

import java.util.concurrent.CountDownLatch;

/**
 * Test CountDownLatch
 */
public class TestHarness {

    public long timeTasks(int nThreads, final Runnable task) throws InterruptedException {
        final CountDownLatch startGate = new CountDownLatch(1);
        final CountDownLatch endGate = new CountDownLatch(nThreads);

        for (int i = 0; i < nThreads; i++) {
            Thread t = new Thread() {
                @Override
                public void run() {
                    try {
                        startGate.await();
                        try {
                            task.run();
                        } finally {
                            endGate.countDown();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            t.start();
        }

        long start = System.nanoTime();
        startGate.countDown();
        endGate.await();
        long end = System.nanoTime();

        return end - start;
    }

    public static void main(String[] args) throws InterruptedException {
        Runnable t = new Runnable() {
            @Override
            public void run() {
                System.out.println(Math.random() * Math.random());
            }
        };

        TestHarness th = new TestHarness();
        long costTime = th.timeTasks(100, t);
        System.out.println("Cost time: " + costTime);
    }

}
