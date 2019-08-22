package cn.rs.demo.tij.strings;

import cn.rs.demo.tij.util.TextFile;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Exercise 17: (8) Write a program that reads a Java source-code file
 * (you provide the file name on the command line) and displays all the comments.
 */

// A very simple version of the "grep" program.
// {Args: Exercise17.java}
public class Exercise17 {

    public static void main(String[] args) {

        if (args.length == 0) {
            System.out.println("Usage: java Exercise17.java");
            System.exit(0);
        }

        // Iterate through the lines of the input file:
        int index = 0;
        Matcher m = Pattern.compile("").matcher("");
        for (String line : new TextFile(args[0])) {
            m.reset(line);
            for (String regex : new String[]{"/\\*{2,}.*", "/{2,}.*", "\\s{1,}\\*.*"}) {
                m.usePattern(Pattern.compile(regex));
                while (m.find())
                    System.out.println(index++ + ": " +
                            m.group() + ": " + m.start());
            }

        }


    }

}
