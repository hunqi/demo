package jvm.ch8.polymorphic;

public class DynamicDispatch {

    static abstract class Human {
        void sayHello() {
            System.out.println("Hello, guy");
        }
    }

    static class Man extends Human {
        void sayHello() {
            System.out.println("Hello, gentleman");
        }
    }

    static class Woman extends Human {
        void sayHello() {
            System.out.println("Hello, lady");
        }
    }

    void sayHello(Human human) {
        human.sayHello();
    }

    public static void main(String[] args) {
        DynamicDispatch dd = new DynamicDispatch();
        Human man = new Man();
        Human woman = new Woman();

        dd.sayHello(man);
        dd.sayHello(woman);
    }

}
