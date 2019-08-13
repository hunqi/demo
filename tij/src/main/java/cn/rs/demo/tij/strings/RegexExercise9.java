package cn.rs.demo.tij.strings;

/**
 * Exercise 9: (4) Using the documentation for java.util.regex.Pattern as a resource,
 * replace all the vowels in Splitting.knights with underscores.
 */
public class RegexExercise9 {

    static String s = Splitting.knights;

    public static void main(String[] args) {
        System.out.println(s.replaceAll("a|e|i|o|u", "_"));
    }

}
