package v2ch06.localdates;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

public class TemporalAdjustersTest {

    public static void main(String[] args) {
        LocalDate nextWednesday = LocalDate.now().with(TemporalAdjusters.next(DayOfWeek.WEDNESDAY));
        System.out.println("nextWednesday: " + nextWednesday);

        System.out.println("nextWorkday: " + nextWorkday());
    }

    public static LocalDate nextWorkday() {
        TemporalAdjuster nwd = w -> {
            LocalDate result = (LocalDate) w;
            do {
                result = result.plusDays(1);
            } while (result.getDayOfWeek().getValue() >= 6);
            return result;
        };

        return LocalDate.now().with(nwd);
    }

}
