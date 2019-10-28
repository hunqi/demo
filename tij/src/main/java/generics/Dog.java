package generics;

import util.New;

import java.util.List;
import java.util.Map;

public class Dog {
    String name;

    public Dog(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "name=" + name;
    }

    static class Person {
        String name;

        public Person(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) {
        List<Object> wangwangdui = New.list();
        wangwangdui.add(new Dog("laiFu"));
        wangwangdui.add(new Dog("xiaoLi"));
        System.out.println("wangwangdui members: " + wangwangdui);

        Map<Object, Object> wwd2 = New.map();
        Person tom = new Person("tom");
        wwd2.put(tom, New.list());
        ((List)wwd2.get(tom)).add(new Dog("xiaoLi"));
        ((List)wwd2.get(tom)).add(new Dog("laiFu"));

        System.out.printf("%s's member: %s", tom, wwd2.get(tom));
    }
}
