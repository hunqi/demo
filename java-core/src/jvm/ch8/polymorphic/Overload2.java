package jvm.ch8.polymorphic;

import java.io.Serializable;

/**
 * int as method parameter
 * <p>
 * overload order is : int > long > Serializable > Object
 * we can see that hello(short s) won't be invoked, as int to short is not safe.
 */
public class Overload2 {

    public static void hello(Object obj) {
        System.out.println("hello, Object");
    }

    public static void hello(int i) {
        System.out.println("hello, int");
    }

    public static void hello(long l) {
        System.out.println("hello, long");
    }

    public static void hello(Character character) {
        System.out.println("hello, Character");
    }

    public static void hello(short s) {
        System.out.println("hello, short");
    }

    public static void hello(char... cs) {
        System.out.println("hello, char[] ...");
    }

    public static void hello(Serializable s) {
        System.out.println("hello, Serializable");
    }

    public static void main(String[] args) {
        hello(100);
    }

}
