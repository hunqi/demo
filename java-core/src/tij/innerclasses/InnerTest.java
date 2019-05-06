package tij.innerclasses;

public class InnerTest {

    public static void main(String[] args) {
        Outer outer = new Outer("Tom");
        Outer.Inner inner = outer.inner();
        System.out.println(inner);
    }

}
