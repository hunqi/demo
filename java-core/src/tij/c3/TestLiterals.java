package tij.c3;

public class TestLiterals {

    public static void main(String[] args) {

        int a = 011;    //octal notation
        System.out.println(a + ", binary: " + Integer.toBinaryString(a));

        int a1 = 0x11a; // hexadecimal
        System.out.println(a1 + ", binary: " + Integer.toBinaryString(a1));

        long b = 011;
        System.out.println(b + ", binary: " + Long.toBinaryString(b));

        long b1 = 0x123acd;
        System.out.println(b1 + ", binary: " + Long.toBinaryString(b1));

        // exponential notation
        float f1 = 1.28e-3f;
        System.out.println("f1=" + f1);

        System.out.println("Float.MAX_EXPONENT=" + Float.MAX_EXPONENT); // 127
        System.out.println("Float.MIN_EXPONENT=" + Float.MIN_EXPONENT); // -126


        System.out.println("Double.MAX_EXPONENT=" + Double.MAX_EXPONENT);   // 1023
        System.out.println("Double.MIN_EXPONENT=" + Double.MIN_EXPONENT);   // -1022

        double maxDouble = 1.3e308;
//        Double.
        System.out.println(Double.doubleToLongBits(maxDouble));

    }

}
