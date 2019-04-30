package tij.holding.excs18;

import java.util.*;

public class DemonstrateMap {

    public static void main(String[] args) {

        Map<String, Country> map = new HashMap<>();
        map.put("China", new Country("China", "west high and east low"));
        map.put("Japan", new Country("Japan", "an island country next to China"));
        map.put("Russia", new Country("Russia", "the most wide country owning land"));
        map.put("America", new Country("America", "nearby oceans on both west and east sides"));
        map.put("India", new Country("India", "nearby india ocean"));
        map.put("England", new Country("England", "an island country on west side of Europe"));

        System.out.println("countries: ");
        System.out.println(map);

        Set<String> keys = new TreeSet<>();
        keys.addAll(map.keySet());

        Map<String, Country> map1 = new LinkedHashMap<>();
        for (String k : keys){
            map1.put(k, map.get(k));
        }

        Set<Map.Entry<String, Country>> entries = map1.entrySet();
        for (Map.Entry<String, Country> entry : entries)
            System.out.println(entry.getKey() + " : " + entry.getValue());
    }

    static class Country {
        String name;
        String description;

        public Country(String name, String description) {
            this.name = name;
            this.description = description;
        }

        @Override
        public String toString() {
            return name + " is " + description;
        }
    }

}
