package jvm.ch8.polymorphic;

public class StaticDispatch2 {

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
        StaticDispatch2 sd = new StaticDispatch2();
        Human man = new Man();
        man = new Woman();
        //java.lang.ClassCastException: jvm.ch8.polymorphic.StaticDispatch2$Woman cannot be cast to jvm.ch8.polymorphic.StaticDispatch2$Man
        sd.sayHello((Man)man);
        sd.sayHello((Woman)man);
    }

}
