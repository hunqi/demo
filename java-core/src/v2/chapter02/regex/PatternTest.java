package v2.chapter02.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * example of Pattern
 */
public class PatternTest {

    public static void main(String[] args) {
        Pattern p = Pattern.compile("a*b");
        Matcher m = p.matcher("aaaaab");
        boolean b = m.matches();
        System.out.println("b: " + b);
        System.out.println("user.dir: " + System.getProperty("user.dir"));
    }

}
