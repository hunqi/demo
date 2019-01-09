package v2ch06;

import java.time.LocalDate;

public class LocalDateTest {

    public static void main(String[] args) {
        LocalDate programmersDay = LocalDate.of(2020, 1, 1).plusDays(255);
        System.out.println(programmersDay);
    }

}
