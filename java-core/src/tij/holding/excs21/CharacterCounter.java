package tij.holding.excs21;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import tij.util.TextFile;

import java.io.*;
import java.util.*;

public class CharacterCounter {

    public static void main(String[] args) {

        TextFile textFile = new TextFile("gutenberg/alice30.txt", "\\W+");

        Map<String, Integer> map = new TreeMap<>();
        for (String s : textFile)
            map.put(s, map.get(s) == null ? 1 : map.get(s) + 1);

        List<Character> characterList = new ArrayList<>();

        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        for (Map.Entry<String, Integer> entry : entries) {
//            System.out.println(entry.getKey() + " : " + entry.getValue());
            characterList.add(new Character(entry.getKey(), entry.getValue()));
        }

        Collections.sort(characterList, Comparator.comparing(Character::getQuantity).reversed());

        for (Character c : characterList)
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
