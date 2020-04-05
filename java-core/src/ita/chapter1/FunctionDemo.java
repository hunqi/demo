package ita.chapter1;

import java.util.Comparator;

public class FunctionDemo {
    static <T> T findMax(T[] arr, Comparator<? super T> cmp) {
        int maxIndex = 0;
        for (int i = 1; i < arr.length; i++)
            if (cmp.compare(arr[i], arr[maxIndex]) > 0)
                maxIndex = i;
        return arr[maxIndex];
    }

    static class CaseInsensitiveCompare implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            return o1.compareToIgnoreCase(o2);
        }
    }

    public static void main(String[] args) {
        String[] arr = {"ZEBRA", "alligator", "crocodile"};
        System.out.println(findMax(arr, new CaseInsensitiveCompare()));
    }
}
