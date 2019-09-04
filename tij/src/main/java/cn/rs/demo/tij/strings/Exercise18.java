package cn.rs.demo.tij.strings;

import cn.rs.demo.tij.util.TextFile;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Exercise 18: (8) Write a program that reads a Java source-code file
 * (you provide the file name on the command line) and displays all the
 * string literals in the code.
 */
public class Exercise18 {

    private static final String STR1 = "hello, world";

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Usage: java aClassName.java");
            System.exit(0);
        }

        // Iterate through the lines of the input file:
        int index = 0;
        Matcher m = Pattern.compile("\".*\"").matcher("");
        for (String line : new TextFile(args[0])) {
            m.reset(line);
            while (m.find())
                System.out.println(index++ + ": " +
                        m.group() + ": " + m.start());

        }
    }

    private static final String STR2 = "hello, math";

}
