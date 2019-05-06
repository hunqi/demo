package tij.holding.excs29;

import java.util.PriorityQueue;

// tij.holding.excs29.PriorityQueueDemo$Mouse cannot be cast to java.lang.Comparable will occur.
// Object put into PriorityQueue must implement Comparable interface
public class PriorityQueueDemo {

    public static void main(String[] args) {

        PriorityQueue<Mouse> priorityQueue = new PriorityQueue<>();
        for (int i=0; i<5; i++)
            priorityQueue.offer(new Mouse());

        System.out.println(priorityQueue.size());
    }

    private static class Mouse {}

}