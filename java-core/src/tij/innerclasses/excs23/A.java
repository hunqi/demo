package tij.innerclasses.excs23;

public class A {

    public U createU() {
        return new U() {
            @Override
            public void f() {
                System.out.println("f()");
            }

            @Override
            public void f2() {
                System.out.println("f2()");
            }

            @Override
            public void f3() {
                System.out.println("f3()");
            }
        };
    }

}
