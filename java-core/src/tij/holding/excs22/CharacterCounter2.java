package tij.holding.excs22;

import tij.util.TextFile;

import java.util.*;

public class CharacterCounter2 {

    public static void main(String[] args) {

        TextFile textFile = new TextFile("gutenberg/alice30.txt", "\\W+");

        Map<String, Integer> map = new TreeMap<>();
        for (String s : textFile)
            map.put(s, map.get(s) == null ? 1 : map.get(s) + 1);

        Set<Character> characterSet = new TreeSet<>(Comparator.comparing(Character::getQuantity).reversed());
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        for (Map.Entry<String, Integer> entry : entries) {
            characterSet.add(new Character(entry.getKey(), entry.getValue()));
        }

        for (Character c : characterSet)
            System.out.println(c);
    }

    static class Character {
        String value;
        Integer quantity;

        public Character(String value, Integer quantity) {
            this.value = value;
            this.quantity = quantity;
        }

        public Integer getQuantity() {
            return quantity;
        }

        @Override
        public String toString() {
            return quantity + " " + value;
        }
    }

}
