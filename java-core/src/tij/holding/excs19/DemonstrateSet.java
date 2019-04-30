package tij.holding.excs19;

import java.util.*;

public class DemonstrateSet {

    public static void main(String[] args) {

        Set<Country> countries = new HashSet<>();
        countries.add(new Country("China", "west high and east low"));
        countries.add(new Country("Japan", "an island country next to China"));
        countries.add(new Country("Russia", "the most wide country owning land"));
        countries.add(new Country("America", "nearby oceans on both west and east sides"));
        countries.add(new Country("India", "nearby india ocean"));
        countries.add(new Country("England", "an island country on west side of Europe"));

        System.out.println("countries:");
        System.out.println(countries);

        Set<Country> countries1 = new TreeSet<>();
        countries1.addAll(countries);
        System.out.println("countries1: \n" + countries1);

        Set<Country> countries2 = new LinkedHashSet<>();
        for (Country c : countries1)
            countries2.add(c);
        System.out.println("countries2: \n" + countries2);
    }


    static class Country implements Comparable<Country> {
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

        @Override
        public int compareTo(Country o) {
            int len1 = name.length();
            int len2 = o.name.length();
            int lim = Math.min(len1, len2);
            char v1[] = name.toCharArray();
            char v2[] = o.name.toCharArray();

            int k = 0;
            while (k < lim) {
                char c1 = v1[k];
                char c2 = v2[k];
                if (c1 != c2) {
                    return c1 - c2;
                }
                k++;
            }
            return len1 - len2;
        }
    }
}
