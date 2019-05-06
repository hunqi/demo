package tij.innerclasses;

// exercise1
public class Outer {

    private String name;

    public Outer() {
    }

    public Outer(String name) {
        this.name = name;
    }

    class Inner {
        private int i = 1;
        public int value(){
            return i;
        }

        @Override
        public String toString() {
            return "name=" + name + ", i=" + i;
        }
    }

    public Inner inner(){
        return new Inner();
    }

    public static void main(String[] args) {
        Outer outer = new Outer();
        Inner inner = outer.inner();
    }

}
