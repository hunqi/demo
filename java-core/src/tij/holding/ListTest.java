package tij.holding;

import java.util.*;

public class ListTest {

    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");
        list.add("five");

        System.out.println("list.getFirst(): " + list.getFirst());
        System.out.println("list.element(): " + list.element());
        System.out.println("list.peek(): " + list.peek());

        LinkedList<String> emptyList = new LinkedList<>();
        try {
            System.out.println(emptyList.element());
        } catch (NoSuchElementException e) {
            System.out.println("\t line23: NoSuchElementException" );
        }

        System.out.println("emptyList.peek(): " + emptyList.peek());

        System.out.println("list.removeFirst(): " + list.removeFirst());
        System.out.println("list.remove(): " + list.remove());
        System.out.println("list.poll(): " + list.poll());
        try {
            System.out.println(emptyList.remove());
        } catch (NoSuchElementException e) {
            System.out.println("\t line34: NoSuchElementException" );
        }

        System.out.println("emptyList.poll(): " + emptyList.poll());
        System.out.println("list: " + list);

        list.offer("six");
        System.out.println("after list.offer(x): " + list);
        list.add("seven");
        System.out.println("after list.add(x): " + list);
        list.addLast("eight");
        System.out.println("after list.addLast(x): " + list);

        System.out.println("removeLast: " + list.removeLast());
        System.out.println(list);

        list.add(list.size()/2, "9");
        System.out.println(list);
    }

}
