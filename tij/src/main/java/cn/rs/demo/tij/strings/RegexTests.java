package cn.rs.demo.tij.strings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTests {

    public static void main(String[] args) {

        Matcher matcher = Pattern.compile("import\\s+(\\w+\\.)+([A-Z][a-z0-9]*)+")
                .matcher("import java.util.regex.Pattern");
        if (matcher.find()){
            String[] strings = matcher.group().split("\\.");
            System.out.printf("class: %s", strings[strings.length-1]);
        }

    }

}
