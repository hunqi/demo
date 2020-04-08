package ita.chapter1;

import java.math.BigDecimal;

public class P13 {

    public static void main(String[] args) {

        printDouble("-221111000.230456789869950091256008");
    }

    static void printDouble(String d) {
        BigDecimal bd = new BigDecimal(d);

        int i = Math.abs(bd.intValue());
        BigDecimal decimal = bd.subtract(BigDecimal.valueOf(i));

        if (bd.compareTo(BigDecimal.ZERO) < 0) {
            System.out.printf("-");
            decimal = bd.add(BigDecimal.valueOf(i)).abs();
        }
        printInteger(i);
        System.out.printf(".");
        printDecimal(decimal, false);
    }

    static void printDecimal(BigDecimal d, boolean isMultiplied) {
        if (d.compareTo(BigDecimal.ZERO) == 0) return;

        if (d.compareTo(BigDecimal.ZERO) > 0 && d.compareTo(BigDecimal.ONE) < 0) {
            if (isMultiplied)
                printDigit(0);
            printDecimal(d.multiply(BigDecimal.TEN), true);
        } else {
            int i = d.intValue();
            d = d.subtract(BigDecimal.valueOf(i));
            printDigit(i);
            printDecimal(d.multiply(BigDecimal.TEN), true);
        }
    }

    static void printInteger(int i) {
        if (i >= 10)
            printInteger(i / 10);
        printDigit(i % 10);
    }

    static void printDigit(int i) {
        System.out.printf("%d", i);
    }
}
