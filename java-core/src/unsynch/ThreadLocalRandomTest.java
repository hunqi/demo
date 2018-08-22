package unsynch;

import java.util.concurrent.ThreadLocalRandom;

public class ThreadLocalRandomTest {

    public static void main(String[] args) {

        System.out.println(ThreadLocalRandom.current().nextInt(100));

    }

}
