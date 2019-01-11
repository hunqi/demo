package v2ch07;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class FormatStyleTest {

    public static void main(String[] args) {
        FormatStyle style = FormatStyle.SHORT;
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofLocalizedDate(style);
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofLocalizedTime(style);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofLocalizedDateTime(style);

        System.out.println("date: " + LocalDate.now().format(dateFormatter));
        System.out.println("time: " + LocalTime.now().format(timeFormatter));
        System.out.println("datetime: " + LocalDateTime.now().format(dateTimeFormatter));
    }
}
