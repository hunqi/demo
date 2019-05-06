package tij.ch5.initialization;

public class Eggs {

    Egg egg1;
    Egg egg2;

    {
        egg1 = new Egg(1);
        egg2 = new Egg(2);
        System.out.println("egg1 & egg2 initialized");
    }

    Eggs() {
        System.out.println("Eggs()");
    }

    Eggs(int group) {
        System.out.println("Eggs(" + group + ")");
    }

    public static void main(String[] args) {
        System.out.println("Enter main:");
        new Eggs();
        System.out.println("new Eggs() completed");
        new Eggs(1);
        System.out.println("new Eggs(1) completed");
    }

}

class Egg {
    Egg(int marker) {
        System.out.println("Egg(" + marker + ")");
    }

    void f(int marker) {
        System.out.println("f(" + marker + ")");
    }
}
