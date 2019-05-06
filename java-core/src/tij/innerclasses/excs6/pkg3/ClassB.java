package tij.innerclasses.excs6.pkg3;

import tij.innerclasses.excs6.pkg1.Interface1;
import tij.innerclasses.excs6.pkg2.ClassA;

public class ClassB extends ClassA {

    public Interface1 g(){
        return getInner1();
    }

    public static void main(String[] args) {
        ClassB classB = new ClassB();
        Interface1 i1 = classB.g();
        i1.f();
    }

}
