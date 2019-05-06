package tij.innerclasses.excs8;

public class Outer {

    private class Inner {
        private String name;

        Inner(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    void f(){
        Inner inner = new Inner("Tom");
        System.out.println(inner.name);
    }

    public static void main(String[] args) {
        Outer outer = new Outer();
        outer.f();
    }

}
