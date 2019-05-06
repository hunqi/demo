package tij.ch5;

public class Demotion {

    void f(short s){
        System.out.println("f(s)=" + s);
    }

    public static void main(String[] args) {
        Demotion demotion = new Demotion();
//        demotion.f(6); //compiling error
    }

}
