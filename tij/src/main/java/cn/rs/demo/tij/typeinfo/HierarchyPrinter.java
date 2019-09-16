package cn.rs.demo.tij.typeinfo;

import java.lang.reflect.Field;

public class HierarchyPrinter {

    public static void print(Object instance) throws ClassNotFoundException {
        Class<?> aClass = instance.getClass();

        while (!aClass.equals(Class.forName("java.lang.Object"))) {
            System.out.println(aClass.getName());

            printDeclaredFields(aClass);

            aClass = aClass.getSuperclass();
        }

        System.out.println(aClass.getName());
    }

    static void printDeclaredFields(Class aClass){
        for (Field f : aClass.getDeclaredFields())
            System.out.printf("--- %s\n", f.getName());
    }

    public static void main(String[] args) throws ClassNotFoundException {
        HierarchyPrinter.print(new Student());
    }

}

class Student extends Person {

    String studentId;
    School school;

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }
}

class School {
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class Person {
    String name;
    int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
