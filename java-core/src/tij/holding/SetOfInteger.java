package tij.holding;

import java.util.*;

public class SetOfInteger {

    public static void main(String[] args) {
        Random random = new Random(47);
        Set<Integer> linkedHashSet = new LinkedHashSet<>();
        Set<Integer> hashSet = new HashSet<>();
        Set<Integer> treeSet = new TreeSet<>();

        for (int i=0; i<10000; i++){
            int val = random.nextInt(30);
            linkedHashSet.add(val);
            hashSet.add(val);
            treeSet.add(val);
        }

        System.out.println("linkedHashSet: \t" + linkedHashSet);
        System.out.println("hashSet: \t" + hashSet);
        System.out.println("treeSet: \t" + treeSet);
    }

}
