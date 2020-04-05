package ita.chapter1;

public class ArrayDemo1 {
    public static void main(String[] args) {
        Person[] arr = new Employee[5];
        arr[0] = new Student();
    }
}

class Person {
}

class Employee extends Person {
}

class Student extends Person {
}
