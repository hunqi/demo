package tij.ch7.inheritence;

public class C extends A {

    B b;

    public C(int marker) {
        super(marker - 2);
        System.out.println("C(" + marker + ")");
        b = new B(marker - 1);
    }

    public static void main(String[] args) {
        C c = new C(3);
    }
}

class A {
    A(int marker){
        System.out.println("A(" + marker + ")");
    }
}

class B {
    B(int marker){
        System.out.println("B(" + marker + ")");
    }
}
