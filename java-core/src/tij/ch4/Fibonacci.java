package tij.ch4;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Fibonacci {

    static Integer[] get(int n) {

        if (n == 0)
            return null;

        Integer[] seq = new Integer[n];

        if (n == 1) {
            seq[0] = 1;
        } else if (n == 2) {
            seq[0] = 1;
            seq[1] = 1;
        } else {
            for (int i = 0; i < n; i++) {
                if (i == 0)
                    seq[i] = 1;
                else if (i == 1)
                    seq[i] = 1;
                else
                    seq[i] = seq[i - 1] + seq[i - 2];
            }
        }

        return seq;
    }

    public static void main(String[] args) {
        Integer[] fabo = get(15);
        for (int i = 0, len = fabo.length; i < len; i++) {
            if (i < len - 1)
                System.out.print(fabo[i] + ",");
            else
                System.out.print(fabo[i]);
        }

    }

}
