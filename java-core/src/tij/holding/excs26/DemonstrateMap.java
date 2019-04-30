package tij.holding.excs26;

import tij.util.TextFile;

import java.util.*;

public class DemonstrateMap {

    public static void main(String[] args) {

        TextFile textFile = new TextFile("gutenberg/alice30.txt", "\\W+");

        Map<String, ArrayList<Integer>> map = new LinkedHashMap<>();

        for (int i = 0, len = textFile.size(); i < len; i++) {
            if (map.get(textFile.get(i)) == null) {
                map.put(textFile.get(i), new ArrayList<>());
            }

            map.get(textFile.get(i)).add(i);
        }

        Set<Map.Entry<String, ArrayList<Integer>>> entries = map.entrySet();
        for (Map.Entry<String, ArrayList<Integer>> etr : entries)
            System.out.println(etr.getKey() + " : " + etr.getValue());
    }

}
