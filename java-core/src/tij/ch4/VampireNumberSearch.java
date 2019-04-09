package tij.ch4;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class VampireNumberSearch {

    public static void main(String[] args) {

        Set<Integer> set = new TreeSet<>();

        for (int i = 1001; i < 10000; i++) {
            for (int j = 10; j < 100; j++) {
                if (i % 100 == 0)
                    continue;

                if (i % j == 0 && (i / j >= 10 && i / j < 100)) {
                    int quotient = i / j;
                    String s1 = j + "" + quotient;

                    List<String> l1 = new ArrayList<>();
                    for (int k = 0, len = s1.length(); k < len; k++) {
                        l1.add(String.valueOf(s1.charAt(k)));
                    }

                    String s2 = i + "";
                    List<String> l2 = new ArrayList<>();
                    for (int m = 0; m < s2.length(); m++) {
                        l2.add(String.valueOf(s2.charAt(m)));
                    }

                    if (l1.containsAll(l2) && l2.containsAll(l1)) {
                        if (!set.contains(i)) {
                            System.out.println(i + ", " + j + " x " + quotient);
                            set.add(i);
                        }
                    }
                }
            }

        }

        System.out.println();
        System.out.println("All 4-digit vampire numbers are: " + set);
    }

}
