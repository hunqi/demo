package discretemath;

import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.*;

/**
 * 寻找一个可以用两种不同方式写成正整数的平方和的正整数
 */
public class FindNumberEqualsWithSumOfTwoPerfectSqares {

    final static int BATCH_SIZE = 250000;

    public static void main(String[] args) {
        System.out.printf("available processors: %d\n", Runtime.getRuntime().availableProcessors());

//        ExecutorService pool = Executors.newFixedThreadPool(4);

        int batchNum = 1000000;
        int batch = batchNum / BATCH_SIZE;

        new FindSquareNumPairsTask(1, BATCH_SIZE).run();

        /*for (int i = 1; i <= batch; i++) {
            pool.execute(new FindSquareNumPairsTask(i, BATCH_SIZE));
        }*/
    }
}

class FindSquareNumPairsTask implements Runnable {

    int index;
    int batchSize;

    public FindSquareNumPairsTask(int index, int batchSize) {
        this.index = index;
        this.batchSize = batchSize;
    }

    @Override
    public void run() {
        for (int i = (index - 1) * batchSize + 1; i < index * batchSize; i++) {
            if (i == 1000) System.exit(0);

            if (i % 1000 == 0)
                System.out.printf("%s: find square sum for number: %d\n",
                        Thread.currentThread().getName(),
                        i);
            SquareNumPairs pairs = findSquareSum(i);
            if (pairs != null) {
                System.out.println(pairs);
            }
        }
    }

    SquareNumPairs findSquareSum(int n) {
        SquareNumPairs pairs = new SquareNumPairs();
        int r = 0;
        for (int i = 1; i < n; i++) {
            if (i * i < n) {
                r = n - i * i;

                if (isInteger(Math.sqrt(r))) {
                    SquareNumPair tmp = new SquareNumPair(i * i, r);
                    if (pairs.isEmpty())
                        pairs.add(tmp);
                    else if (!pairs.contains(tmp)) {
                        pairs.add(tmp);
                    }
                }
            }
        }

        if (pairs.size() >= 2) return pairs;
        return null;
    }

    boolean isInteger(double n) {
        return Math.ceil(n) == Math.floor(n);
    }
}

class SquareNumPairs extends ArrayList<SquareNumPair> {
}

class SquareNumPair {
    Integer firstNum;
    Integer secondNum;

    public SquareNumPair(Integer firstNum, Integer secondNum) {
        this.firstNum = firstNum;
        this.secondNum = secondNum;
    }

    public Integer getFirstNum() {
        return firstNum;
    }

    public void setFirstNum(Integer firstNum) {
        this.firstNum = firstNum;
    }

    public Integer getSecondNum() {
        return secondNum;
    }

    public void setSecondNum(Integer secondNum) {
        this.secondNum = secondNum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SquareNumPair that = (SquareNumPair) o;
        return Objects.equals(firstNum, that.firstNum)
                || Objects.equals(firstNum, that.secondNum);
    }

    @Override
    public String toString() {
        return "{" +
                "firstNum=" + firstNum +
                ", secondNum=" + secondNum +
                '}';
    }
}
