package cn.rs.demo.tij.str;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static java.util.Calendar.MAY;

public class FormatterTests {

    public static void main(String[] args) {

        Date now = new Date();
        System.out.println("yyyy-mm-dd");
        System.out.printf("%1$tY-%1$tm-%1$td%n", now);
        System.out.printf("%1$tY-%<tm-%<td%n", now);

        System.out.printf("Local time: %tT%n", Calendar.getInstance());

        Calendar c = new GregorianCalendar(1995, MAY, 23);
        System.out.printf("Duke's Birthday: %1$tb %1$te, %1$tY%n", c);

        System.out.printf("now is %1$tH:%1$tM:%1$tS.%1$tL %1$tB %1$td %1$tY %1$tA%n", now);

        System.out.println("following conversion characters are used for formatting common date/time compositions");
        System.out.printf("%1$tR%n", now);
        System.out.printf("%1$tT%n", now);
        System.out.printf("%1$tr%n", now);
        System.out.printf("%1$tD%n", now);                  // "%tm/%td/%tY" -> 07/10/19
        System.out.printf(String.format("%1$tF%n", now));   // "%tY-%tm-%td" -> 2019-07-10
        System.out.printf(String.format("%1$tc%n", now));   // "%ta %tb %td %tT %tZ %tY" -> 星期三 七月 10 17:38:40 CST 2019

        System.out.printf("%1$s %<S%n", "hello");
        System.out.printf("%1$s %<S%n", "hello");


    }

}
