package cn.rs.demo.tij.strings;

import cn.rs.demo.tij.util.TextFile;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//Exercise 15: (5) Modify JGrep.java to accept flags as arguments
// (e.g., Pattern.CASE_INSENSITIVE, Pattern.MULTILINE).

//: strings/JGrep.java
// A very simple version of the "grep" program.
// {Args: JGrep.java "\\b[Ssct]\\w+"}
public class JGrep2 {

    public static void main(String[] args) {

        if (args.length < 3) {
            System.out.println("Usage: java JGrep file regex");
            System.exit(0);
        }
        Pattern p = Pattern.compile(args[2] + args[1]);
// Iterate through the lines of the input file:
        int index = 0;
        Matcher m = p.matcher("");

        for (String line : new TextFile(args[0])) {
            m.reset(line);
            while (m.find())
                System.out.println(index++ + ": " +
                        m.group() + ": " + m.start());
        }

    }

}
