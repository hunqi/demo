package cn.rs.demo.tij.strings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest {

    public static void main(String[] args) {

        Matcher matcher = Pattern.compile("/\\*{1,}.*").matcher("/**");
        if (matcher.find())
            System.out.println(matcher.group());

    }

}
