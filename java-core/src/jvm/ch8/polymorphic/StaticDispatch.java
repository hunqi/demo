package jvm.ch8.polymorphic;

public class StaticDispatch {

    static abstract class Human {}
    static class Man extends Human {}
    static class Woman extends Human {}

    public void sayHello(Human h){
        System.out.println("Hello, guy");
    }

    public void sayHello(Man m){
        System.out.println("Hello, gentleman");
    }

    public void sayHello(Woman w){
        System.out.println("Hello, lady");
    }

    public static void main(String[] args) {
        StaticDispatch sd = new StaticDispatch();
        Human man = new Man();
        Human woman = new Woman();
        sd.sayHello(man);
        sd.sayHello(woman);
    }

}
