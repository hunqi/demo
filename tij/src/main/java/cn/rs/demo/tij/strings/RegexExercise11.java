package cn.rs.demo.tij.strings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Exercise 11: (2) Apply the regular expression
 * (?i)((^[aeiou])|(\s+[aeiou]))\w+?[aeiou]\b
 * to
 * "Arline ate eight apples and one orange while Anita hadn’t any"
 */
public class RegexExercise11 {

    public static void main(String[] args) {
        Pattern p = Pattern.compile("(?i)((^[aeiou])|(\\s+[aeiou]))\\w+?[aeiou]\\b");
        Matcher matcher = p.matcher("Arline ate eight apples and one orange while Anita hadn’t any");
        System.out.println(matcher.matches());
    }

}
