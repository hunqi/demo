package jvm.ch8.polymorphic;

public class StaticDispatch4 {

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
        StaticDispatch4 sd = new StaticDispatch4();
        sd.sayHello(new Man());
        sd.sayHello(new Woman());
    }

}
