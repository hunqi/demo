package parallel;

import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

/**
 * Listing 1.8 demonstrates how to work with parallel streams
 */
public class ParallelStreams {

    public static void main(String[] args) throws IOException {
        String contents = new String(
                Files.readAllBytes(Paths.get("PrideAndPrejudice.txt")),
                StandardCharsets.UTF_8);
        List<String> words = Arrays.asList(contents.split("\\PL+"));

        //Very bad code ahead
        int[] shordWords = new int[10];
        words.parallelStream().forEach(s -> {
            if (s.length() < 10) shordWords[s.length()]++;
        });
        System.out.println(Arrays.toString(shordWords));

        //Try again, the result will likely be different(and also wrong)
        Arrays.fill(shordWords, 0);
        words.parallelStream().forEach(s -> {
            if (s.length() < 10) shordWords[s.length()]++;
        });
        System.out.println(Arrays.toString(shordWords));

        //Remedy: Group and count
        Map<Integer, Long> shortWordCounts = words.parallelStream()
                .filter(s -> s.length() < 10)
                .collect(Collectors.groupingBy(String::length, Collectors.counting()));
        System.out.println(shortWordCounts);

        //Downstream order not deterministic
        ConcurrentMap<Integer, List<String>> result = words.parallelStream()
                .collect(Collectors.groupingByConcurrent(String::length));
        System.out.println(result.get(14));

        result = words.parallelStream().collect(Collectors.groupingByConcurrent(String::length));
        System.out.println(result.get(14));

        ConcurrentMap<Integer, Long> wordCounts = words.parallelStream()
                .collect(Collectors.groupingByConcurrent(String::length, Collectors.counting()));
        System.out.println(wordCounts);
    }

}
