package v2ch06.localtime;

import java.time.LocalTime;

public class LocalTimeTest {

    public static void main(String[] args) {
        LocalTime now = LocalTime.now();
        LocalTime bedtime = LocalTime.of(22, 00);
        LocalTime wakeup = bedtime.plusHours(8);

        System.out.println("now: " + now);
        System.out.println("bedtime: " + bedtime);
        System.out.println("wakeup: " + wakeup);
    }

}
