package tij.ch7.inheritence;

public class B2 extends B {

//    public B2() {   //compiling error: there is no default constructor available in base class B
//    }

    public B2(int marker) {
        super(marker);
        System.out.println("B2(" + marker + ")");
    }

}
