package cn.rs.demo.tij.strings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Exercise 10: (2) For the phrase "Java now has regular expressions" evaluate whether
 * the following expressions will find a match:
 * ^Java
 * \Breg.*
 * n.w\s+h(a|i)s
 * s?
 * s*
 * s+
 * s{4}
 * S{1}.
 * s{0,3}
 */
public class RegexExercise10 {

    public static void main(String[] args) {

        if (args.length < 2) {
            System.out.println("You must provide 2 arguments at least");
            System.exit(0);
        }

        System.out.println("Input: " + args[0]);
        for (String arg : args) {
            System.out.println("Regular expression: " + arg);
            Pattern p = Pattern.compile(arg);
            Matcher m = p.matcher(args[0]);
            while (m.find())
                System.out.println("Match \"" + m.group()
                        + "\" at positions "
                        + m.start() + "-" + (m.end() - 1));
        }
    }

}
