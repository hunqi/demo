package optional;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

/**
 * This example demonstrates Optional API
 */
public class OptionalTest {

    public static void main(String[] args) throws IOException {
        String contents = new String(Files.readAllBytes(Paths.get("test_data.txt")), StandardCharsets.UTF_8);
        List<String> wordList = Arrays.asList(contents.split("\\PL+"));
        Optional<String> optionalValue = wordList.stream().filter(s -> s.contains("深圳")).findFirst();
        System.out.println(optionalValue.orElse("Not word") + " contains 深圳");
        Optional<String> optionalString = Optional.empty();
        String result = optionalString.orElse("N/A");
        System.out.println("result: " + result);
        result = optionalString.orElseGet(() -> System.getProperty("user.dir"));
        System.out.println("result: " + result);
        try {
            result = optionalString.orElseThrow(IllegalStateException::new);
        }catch (Throwable e){
            e.printStackTrace();
        }

        optionalString = wordList.stream().filter(s -> s.contains("北京")).findFirst();
        optionalString.ifPresent(s -> System.out.println(s + " contains 北京"));

        Set<String> results = new HashSet<>();

    }

    static Optional<Double> inverse(Double x) {
        return x == 0 ? Optional.empty() : Optional.of(1 / x);
    }

    static Optional<Double> squareRoot(Double x) {
        return x < 0 ? Optional.empty() : Optional.of(Math.sqrt(x));
    }
}
