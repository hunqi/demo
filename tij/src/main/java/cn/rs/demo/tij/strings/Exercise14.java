package cn.rs.demo.tij.strings;

import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * Exercise 14: (1) Rewrite SplitDemo using String.split( ).
 */
public class Exercise14 {

    public static void main(String[] args) {
        String input = "This!!unusual use!!of exclamation!!points";
        System.out.println(Arrays.toString(input.split("!!")));
        // Only do the first three:
        System.out.println(Arrays.toString(input.split("!!", 3)));
    }

}
