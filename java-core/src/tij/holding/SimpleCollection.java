package tij.holding;

import java.util.ArrayList;
import java.util.Collection;
import java.util.TreeSet;

public class SimpleCollection {
    public static void main(String[] args) {
        Collection<Integer> c = new TreeSet<>();

        for (int i = 0; i < 10; i++)
            c.add(i); // Autoboxing
        for (Integer i : c)
            System.out.print(i + ", ");
    }
}
