package tij.holding.excs28;

import java.util.PriorityQueue;
import java.util.Random;

public class PriorityQueueDemo {

    public static void main(String[] args) {
        Random random = new Random(50);
        PriorityQueue<Double> priorityQueue = new PriorityQueue<>();
        for (int i=0; i<10; i++)
            priorityQueue.offer(random.nextDouble());

        Double d = null;
        while ((d = priorityQueue.poll()) != null)
            System.out.println(d);

    }

}
