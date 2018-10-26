package util;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

/**
 * Demonstrate convert LocalDateTime to Instant
 */
public class LocalDateTimeTest {

    private static final DateTimeFormatter DTF_YYYYMMDDHHMMSS = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");

    public static void main(String[] args) {
        String dStr1 = "20180101000000";
        String dStr2 = "20180101120000";

        System.out.println("result=" + getPlusOneHourString(dStr1, dStr2));
    }

    private static String getPlusOneHourString(String startTime, String endTime) {
        LocalDateTime d1 = LocalDateTime.parse(startTime, DTF_YYYYMMDDHHMMSS);
        LocalDateTime d2 = LocalDateTime.parse(endTime, DTF_YYYYMMDDHHMMSS);

        int hours = (int) ((d2.toEpochSecond(ZoneOffset.of("+8")) - d1.toEpochSecond(ZoneOffset.of("+8"))) / 3600);
        if (hours >= 2) {
            d2 = d1.plusHours(hours / 2);
            System.out.println("endTime=" + d2.format(DTF_YYYYMMDDHHMMSS));
            return getPlusOneHourString(startTime, d2.format(DTF_YYYYMMDDHHMMSS));
        } else {
            return endTime;
        }
    }

}
