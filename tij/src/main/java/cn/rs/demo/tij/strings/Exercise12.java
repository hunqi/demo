package cn.rs.demo.tij.strings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Exercise 12: (5) Modify Groups.java to count all of the unique words
 * that do not start with a capital letter.
 */
public class Exercise12 {

    static public final String POEM =
            "Twas brillig, and the slithy toves\n" +
                    "Did gyre and gimble in the wabe.\n" +
                    "All mimsy were the borogoves,\n" +
                    "And the mome raths outgrabe.\n\n" +
                    "Beware the Jabberwock, my son,\n" +
                    "The jaws that bite, the claws that catch.\n" +
                    "Beware the Jubjub bird, and shun\n" +
                    "The frumious Bandersnatch.";

    public static void main(String[] args) {
        Matcher matcher = Pattern.compile("\\s+[a-z](\\w*)").matcher(POEM);

        int cnt=0;
        while (matcher.find()){
            System.out.print(matcher.group() + ", ");
            cnt++;
        }
        System.out.println();
        System.out.println("totol=" + cnt);
    }

}
