package jvm.ch8.polymorphic;

import java.io.Serializable;

/**
 * char as method parameter
 *
 * overload order is : char > int > long > Character > Serializable > Object > char ...
 * which means char ... has lowest priority
 */
public class Overload {

    public static void hello(Object obj){
        System.out.println("hello, Object");
    }

    public static void hello(int i){
        System.out.println("hello, int");
    }

    public static void hello(long l){
        System.out.println("hello, long");
    }

    public static void hello(Character character){
        System.out.println("hello, Character");
    }

    public static void hello(char c){
        System.out.println("hello, char");
    }

    public static void hello(char ... cs){
        System.out.println("hello, char[] ...");
    }

    public static void hello(Serializable s){
        System.out.println("hello, Serializable");
    }

    public static void main(String[] args) {
        hello('a');
    }

}
