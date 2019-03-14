package jcpia.synchronizer;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest2 {

    public static void main(String[] args) throws InterruptedException {

        final CountDownLatch gate = new CountDownLatch(2);
        final Number number = new Number();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                number.setN1(6);
                gate.countDown();
            }
        });
        t1.start();

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                number.setN2(9);
                gate.countDown();
            }
        });
        t2.start();

        gate.await();

        System.out.println("Result=" + number.getN1() + " * " + number.getN2());
    }

    static class Number {
        int n1;
        int n2;

        public int getN1() {
            return n1;
        }

        public void setN1(int n1) {
            this.n1 = n1;
        }

        public int getN2() {
            return n2;
        }

        public void setN2(int n2) {
            this.n2 = n2;
        }
    }

}
