package util;

import generics.watercolors.Watercolors;

import java.util.EnumSet;
import java.util.Set;

public class EnumSetTests {
    public static void main(String[] args) {
        Set<Watercolors> s = EnumSet.noneOf(Watercolors.class);
        System.out.println(s.size());

        s = EnumSet.range(Watercolors.ZINC, Watercolors.ORANGE);
        System.out.println(s.size());
        System.out.println(s);
        System.out.println(s.contains(Watercolors.ZINC));
        System.out.println(s.contains(Watercolors.BRILLIANT_RED));
        s = EnumSet.allOf(Watercolors.class);
        System.out.println(s.size());
    }

    enum Number {
        ONE, TWO, THREE;
    }
}
