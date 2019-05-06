package tij.ch7.inheritence;

public class Stem extends Root {
    private Component1 component1;
    private Component2 component2;
    private Component3 component3;

    public Stem(int marker) {
        super(marker - 1);

        component1 = new Component1(12);
        component2 = new Component2(22);
        component3 = new Component3(32);

        System.out.printf("Stem(%s)\n", marker);
    }

    public static void main(String[] args) {
        new Stem(2);
    }
}

class Root {
    private Component1 component1;
    private Component2 component2;
    private Component3 component3;

    public Root(int marker) {
        component1 = new Component1(1);
        component2 = new Component2(2);
        component3 = new Component3(3);
        System.out.printf("Root(%s)\n", marker);
    }
}

class Component1{
    Component1(int marker){
        System.out.printf("Component1(%s)\n", marker);
    }
}

class Component2{
    Component2(int marker){
        System.out.printf("Component2(%s)\n", marker);
    }
}

class Component3{
    Component3(int marker){
        System.out.printf("Component3(%s)\n", marker);
    }
}
