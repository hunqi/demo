package cn.rs.demo.tij.strings;

import java.util.Scanner;

public class ScannerDelimiter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner("12, 42, 78, 99, 42");
        System.out.println("default delimiter: " + scanner.delimiter());
        scanner.useDelimiter("\\s*,\\s*");
        System.out.println("current delimiter: " + scanner.delimiter());
        while (scanner.hasNextInt())
            System.out.println(scanner.nextInt());
    }

}
