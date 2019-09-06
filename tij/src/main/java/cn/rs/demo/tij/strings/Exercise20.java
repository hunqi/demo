package cn.rs.demo.tij.strings;

import java.util.Scanner;

/**
 * Exercise 20: (2) Create a class that contains int, long, float and
 * double and String fields. Create a constructor for this class that
 * takes a single String argument, and scans that string into the various fields.
 * Add a toString( ) method and demonstrate that your class works correctly.
 */
public class Exercise20 {

    private int i;
    private long l;
    private float f;
    private double d;
    private String s;

    public Exercise20(String input){
        Scanner scanner = new Scanner(input);
        i = scanner.nextInt();
        l = scanner.nextInt();
        f = scanner.nextFloat();
        d = scanner.nextDouble();
        s = scanner.next();
        scanner.close();
    }

    @Override
    public String toString() {
        return "i=" + i +
                ", l=" + l +
                ", f=" + f +
                ", d=" + d +
                ", s=" + s;
    }

    public static void main(String[] args) {
        Exercise20 exercise20 = new Exercise20("1 2 1.0 2.0 hello");
        System.out.println(exercise20);
    }
}
