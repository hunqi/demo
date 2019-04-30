package tij.holding.excs20;

import tij.util.TextFile;

import java.util.*;
import java.util.stream.Collectors;

public class UniqueWords {

    public static void main(String[] args) {

        TextFile strings = new TextFile("D:\\ray.sun\\git\\demo\\java-core\\src\\tij\\holding\\SetOperations.java", "\\W+");
//        System.out.println("strings: \n" + strings + "\n");

        Set<String> words = new TreeSet<>(strings);
        System.out.println(words + "\n");

        Set<String> vowelSet = new HashSet<>();
        vowelSet.addAll(Arrays.asList("a", "e", "i", "o", "u", "A", "E", "I", "O", "U"));

        Map<String, Integer> vowelCountMap = new HashMap<>();

        for (String s : words) {
            for (int i = 0, len = s.length(); i < len; i++) {
                if (vowelSet.contains(s.charAt(i) + "")) {
                    vowelCountMap.put(s.charAt(i) + "", vowelCountMap.get(s.charAt(i) + "") == null ? 1 : vowelCountMap.get(s.charAt(i) + "") + 1);
                }
            }
        }

        System.out.println("occurrence times of each vowel: ");
        System.out.println("\t" + vowelCountMap + "\n");

        System.out.println("total times of vowel occurrence: "
                + vowelCountMap.values().stream().collect(Collectors.summarizingInt(Integer::valueOf)).getSum());
    }

}
