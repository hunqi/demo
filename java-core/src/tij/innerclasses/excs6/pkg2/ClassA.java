package tij.innerclasses.excs6.pkg2;

import tij.innerclasses.excs6.pkg1.Interface1;

public class ClassA {

    protected class Inner1 implements Interface1 {
        @Override
        public void f() {
            System.out.println("ClassA.Inner1.f()");
        }
    }

    protected Inner1 getInner1(){
        return new Inner1();
    }

}
