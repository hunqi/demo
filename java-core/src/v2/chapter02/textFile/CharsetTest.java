package v2.chapter02.textFile;

import java.nio.charset.Charset;

public class CharsetTest {

    public static void main(String[] args) {
        System.out.println("defaultCharset: " + Charset.defaultCharset());
        Charset.availableCharsets().entrySet().forEach(cs -> {
            System.out.println(cs.getKey() + ": " + cs.getValue());
        });
    }
}
