package tij.ch5;

public class DemonstrateThis {

    void f1(){
        f2();
        this.f2();
    }

    void f2(){
        System.out.println("f2() done");
    }

    public static void main(String[] args) {
        DemonstrateThis dt = new DemonstrateThis();
        dt.f1();
    }

}


