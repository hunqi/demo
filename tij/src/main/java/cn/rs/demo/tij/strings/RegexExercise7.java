package cn.rs.demo.tij.strings;

import java.io.FileReader;
import java.io.IOException;

/**
 * Exercise 7: (5) Using the documentation for java.util.regex.Pattern as a resource,
 * write and test a regular expression that checks a sentence to see that it begins with
 * a capital letter and ends with a period.
 */
public class RegexExercise7 {

    public static void main(String[] args) throws IOException {

        FileReader fileReader = new FileReader("java-api/Pattern.txt");
        String firstChar = String.valueOf((char) fileReader.read());
        System.out.println(firstChar);
        System.out.println(firstChar.matches("[A-Z]"));

        int b = -1;
        int c = -1;
        while ((c = fileReader.read()) > -1)
            b = c;

        System.out.println("b=" + b);
        String lastChar = String.valueOf((char)b);
        System.out.println(lastChar);
        System.out.println(lastChar.matches("."));
    }

}
