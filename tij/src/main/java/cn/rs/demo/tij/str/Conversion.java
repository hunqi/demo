package cn.rs.demo.tij.str;

import java.math.BigInteger;
import java.util.Formatter;

/**
 * This class demonstrates that %b, %s, %h suit for all types
 * d - integral (as decimal)
 * c - unicode character
 * b - boolean value
 * s - string
 * f - floating point(as decimal)
 * e - floating point(in scientific notation)
 * x - integral(as hex)
 * h - hash code(as hex)
 * % - literal "%"
 */
public class Conversion {

    public static void main(String[] args) {

        Formatter f = new Formatter(System.out);

        char u = 'a';
        System.out.println("u = 'a'");
        f.format("s: %s%n", u);
//        f.format("d: %d%n", u);   // d != java.lang.Character
        f.format("c: %c%n", u);
        f.format("b: %b%n", u);
//        f.format("f: %f%n", u);     // f != java.lang.Character
//        f.format("e: %e%n", u);     // e != java.lang.Character
//        f.format("x: %x%n", u);     // x != java.lang.Character
        f.format("h: %h%n%n", u);

        int v = 121;
        System.out.println("v = 121");
        f.format("d: %d%n", v);
        f.format("c: %c%n", v);
        f.format("b: %b%n", v);
        f.format("s: %s%n", v);
//        f.format("f: %f%n", v);     // f != java.lang.Integer
//        f.format("e: %e%n", v);     // e != java.lang.Integer
        f.format("x: %x%n", v);
        f.format("h: %h%n%n", v);

        BigInteger w = new BigInteger("50000000000000");
        System.out.println("w = new BigInteger(\"50000000000000\")");
        f.format("d: %d%n", w);
//        f.format("c: %c%n", w);   // c != java.math.BigInteger
        f.format("b: %b%n", w);
        f.format("s: %s%n", w);
//        f.format("f: %f%n", w); // f != java.math.BigInteger
//        f.format("e: %e%n", w); // e != java.math.BigInteger
        f.format("x: %x%n", w);
        f.format("h: %h%n%n", w);

        double x = 179.543;
        System.out.println("x = 179.543");
//        f.format("d: %d%n", x); // d != java.lang.Double
//        f.format("c: %c%n", x);   // c != java.lang.Double
        f.format("b: %b%n", x);
        f.format("s: %s%n", x);
        f.format("f: %f%n", x);
        f.format("e: %e%n", x);
//        f.format("x: %x%n", x); // x != java.lang.Double
        f.format("h: %h%n%n", x);

        Conversion y = new Conversion();
        System.out.println("y = new Conversion()");
//        f.format("d: %d%n", y);   // d != cn.rs.demo.tij.str.Conversion
//        f.format("c: %c%n", y);   // c != cn.rs.demo.tij.str.Conversion
        f.format("b: %b%n", y);
        f.format("s: %s%n", y);
//        f.format("f: %f%n", y); // f != cn.rs.demo.tij.str.Conversion
//        f.format("e: %e%n", y); // e != cn.rs.demo.tij.str.Conversion
//        f.format("x: %x%n", y); // x != cn.rs.demo.tij.str.Conversion
        f.format("h: %h%n%n", y);

        boolean z = false;
        System.out.println("z = false");
//        f.format("d: %d%n", z);   // d != java.lang.Boolean
//        f.format("c: %c%n", z);   // c != java.lang.Boolean
//        f.format("b: %b%n", z);   // f != java.lang.Boolean
        f.format("s: %s%n", z);
//        f.format("f: %f%n", z); // f != java.lang.Boolean
//        f.format("e: %e%n", z); // e != java.lang.Boolean
//        f.format("x: %x%n", z); // x != java.lang.Boolean
        f.format("h: %h%n%n", z);
    }

}
