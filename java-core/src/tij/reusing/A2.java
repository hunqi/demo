package tij.reusing;

import tij.reusing.exercise15.A;

public class A2 extends A {

    public void f2(){
        f();
    }

    public static void main(String[] args) {
        A2 a2 = new A2();
        a2.f2();
    }
}
