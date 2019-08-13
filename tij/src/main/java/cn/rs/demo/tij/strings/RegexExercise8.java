package cn.rs.demo.tij.strings;

import java.util.Arrays;

/**
 * Exercise 8: (2) Split the string Splitting.knights on the words "the" or “you."
 */
public class RegexExercise8 {

    static String s = Splitting.knights;
    public static void main(String[] args) {
        System.out.println(Arrays.toString(s.split("the|you.")));
    }

}
