package tij.innerclasses.excs7;

public class ClassA {

    private String name;

    private void f(){
        System.out.println("f()");
    }

    public void f2(){
        Inner inner = new Inner();
        inner.g();
    }

    @Override
    public String toString() {
        return "[" + name + "]";
    }

    private class Inner {
        void g(){
            name = "Tom";
            f();
        }
    }

    public static void main(String[] args) {
        ClassA a = new ClassA();
        System.out.println(a);
        a.f2();
        System.out.println(a);
    }

}
