package util;

import generics.watercolors.Watercolors;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class Sets2 {
    public static <T> Set<T> union(Set<T> a, Set<T> b) {
        Set<T> result = clone(a);
        result.addAll(b);
        return result;
    }

    public static <T> Set<T> intersection(Set<T> a, Set<T> b) {
        Set<T> result = clone(a);
        result.retainAll(b);
        return result;
    }

    // Subtract subset from superset:
    public static <T> Set<T> difference(Set<T> superset, Set<T> subset) {
        Set<T> result = clone(superset);
        result.removeAll(subset);
        return result;
    }

    // Reflexive--everything not in the intersection:
    public static <T> Set<T> complement(Set<T> a, Set<T> b) {
        return difference(union(a, b), intersection(a, b));
    }

    private static <T> Set<T> clone(Set<T> s) {
        if (s instanceof EnumSet)
            return ((EnumSet) s).clone();
        else
            try {
                Method method = s.getClass().getMethod("clone");
                return (Set<T>) method.invoke(s);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
    }

    public static void main(String[] args) {
        Set<String> s = new TreeSet<>();
        s.add("One");
        s.add("Tree");
        Set<String> s2 = new TreeSet<>();
        s2.add("Two");
        s2.add("Five");

        Set<String> union = Sets2.union(s, s2);
        System.out.println(union);

        Set<Watercolors> s3 = EnumSet.range(Watercolors.ZINC, Watercolors.MEDIUM_YELLOW);
        Set<Watercolors> s4 = EnumSet.of(Watercolors.VIRIDIAN_HUE, Watercolors.ULTRAMARINE);
        Set<Watercolors> union1 = Sets2.union(s3, s4);
        System.out.println(union1);
    }

} ///:~
