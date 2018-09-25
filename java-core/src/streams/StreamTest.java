package streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest {

    public static void main(String[] args) {
        List<String> words = Arrays.asList("hello", "word", "java", "encapsulate", "object");
        System.out.printf("letters=%s \n", letters("hello").collect(Collectors.toList()));

        //map method: When you use map, a function is applied to each element
        //and the result is a new stream with the results.
        Stream<Stream<String>> result = words.stream().map(w -> letters(w));
        System.out.println("result: ");
        result.forEach(s -> {
            System.out.println("\t" + s.collect(Collectors.toList()));
        });
        //flatMap method
        Stream<String> flatResult = words.stream().flatMap(w -> letters(w));
        System.out.println("flatResult: " + flatResult.collect(Collectors.toList()));

        //skip method
        String contents = " Today is Sep 25th 2018, cloudy. I am happy at the current second.";
        Stream<String> words2 = Stream.of(contents.split("\\P{L}+")).skip(1);
        System.out.println("words2: " + words2.collect(Collectors.toList()));

        //concat method
        Stream<String> combined = Stream.concat(letters("Hello"), letters("World"));
        System.out.println("combined: " + combined.collect(Collectors.joining(" ")));

        //distinct method
        Stream<String> uniqueWords = Stream.of("merrily", "merrily", "merrily", "gently").distinct();
        System.out.println(uniqueWords.collect(Collectors.joining(",")));   //only one merrily retained

        //sorted method
        Stream<String> longestFirst = words.stream().sorted(Comparator.comparing(String::length).reversed());
        System.out.println(longestFirst.collect(Collectors.joining(",")));

        //peek method
        Object[] powers = Stream.iterate(1.0, p -> p * 2)
                .peek(e -> System.out.printf("Fetching %s, ", e))
                .limit(20).toArray();
        System.out.printf("\npowers.length=%s", powers.length);


    }

    public static Stream<String> letters(String s) {
        if (null == s || s.length() == 0) return Stream.empty();
        List<String> result = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            result.add(s.substring(i, i + 1));
        }
        return result.stream();
    }

}
