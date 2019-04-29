package tij.holding;

import tij.util.TextFile;

import java.util.*;

public class UniqueWords {

    public static void main(String[] args) {

        TextFile strings = new TextFile("D:\\ray.sun\\git\\demo\\java-core\\src\\tij\\holding\\SetOperations.java", "\\W+");
        System.out.println("strings: \n" + strings + "\n");

        Set<String> words = new TreeSet<>(strings);
        System.out.println(words + "\n");

        Set<String> vowelSet = new HashSet<>();
        vowelSet.addAll(Arrays.asList("a", "e", "i", "o", "u", "A", "E", "I", "O", "U"));

        Map<String, Integer> vowelCountMap = new HashMap<>();

        for (String s : words){
            for (int i=0, len=s.length(); i<len; i++){
              if (vowelSet.contains(s.charAt(i) + "")) {
                  if (vowelCountMap.get(s) != null){
                      vowelCountMap.put(s, vowelCountMap.get(s) + 1);
                  }else {
                      vowelCountMap.put(s, 1);
                  }
              }
            }
        }

        int totalVowels = 0;
        Set<Map.Entry<String, Integer>> entries = vowelCountMap.entrySet();
        for (Map.Entry<String, Integer> m : entries){
            System.out.println(m.getKey() + ": " + m.getValue());
            totalVowels += m.getValue();
        }

        System.out.println("totalVowels: " + totalVowels);
    }

}
