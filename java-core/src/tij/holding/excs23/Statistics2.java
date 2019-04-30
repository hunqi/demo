package tij.holding.excs23;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Statistics2 {

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++)
            run();
    }

    public static void run() {
        Random rand = new Random(47);
        Map<Integer, Integer> m =
                new HashMap<Integer, Integer>();
        for (int i = 0; i < 10000; i++) {
// Produce a number between 0 and 20:
            int r = rand.nextInt(20);
            Integer freq = m.get(r);
            m.put(r, freq == null ? 1 : freq + 1);
        }
        System.out.println(m);
    }

}
