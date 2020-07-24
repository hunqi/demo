package com.example.util;

import java.beans.Introspector;

public class IntrospectorTest {

    public static void main(String[] args) {
        String s = "Java";
        System.out.printf("%s > %s\n", s, Introspector.decapitalize(s));
        s = "CustomerService";
        System.out.printf("%s > %s\n", s, Introspector.decapitalize(s));
        s = "DBUnit";
        System.out.printf("%s > %s\n", s, Introspector.decapitalize(s));
    }

}
