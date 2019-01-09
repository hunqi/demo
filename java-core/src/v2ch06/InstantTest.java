package v2ch06;

import java.time.Duration;
import java.time.Instant;

public class InstantTest {

    public static void main(String[] args) {
        Instant now = Instant.now();
        System.out.println(now);
        System.out.println(now.getEpochSecond());

        Instant start = Instant.now();
        int sum = 0;
        for (int i=0; i<1000000000; i++)
            sum += i;
        Instant end = Instant.now();

        Duration between = Duration.between(start, end);
        System.out.println(between.toMillis());
    }

}
