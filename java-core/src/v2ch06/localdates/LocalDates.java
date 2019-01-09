package v2ch06.localdates;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;

public class LocalDates {

    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        System.out.println("today: " + now);

        LocalDate alonzosBirthday = LocalDate.of(1903, 6, 14);
        alonzosBirthday = LocalDate.of(1903, Month.JUNE, 14);
        System.out.println("alonzosBirthday: " + alonzosBirthday);

        LocalDate programmersDay = LocalDate.of(2019, 1, 1).plusDays(255);
        System.out.println("programmersDay: " + programmersDay);

        LocalDate newYearsDay = LocalDate.of(2019, 1, 1);
        LocalDate nationalDay = LocalDate.of(2019, Month.OCTOBER, 1);
        System.out.println("Until NationalDay: " + newYearsDay.until(nationalDay));
        System.out.println("Until NationalDay: " + newYearsDay.until(nationalDay, ChronoUnit.DAYS));

        DayOfWeek startOfLastMillennium = LocalDate.of(1900, 1, 1).getDayOfWeek();
        System.out.println("startOfLastMillennium: " + startOfLastMillennium);
        System.out.println(startOfLastMillennium.getValue());
        System.out.println(DayOfWeek.SATURDAY.plus(3));
    }

}
