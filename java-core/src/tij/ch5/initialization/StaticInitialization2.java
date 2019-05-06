package tij.ch5.initialization;

public class StaticInitialization2 {

    public static void main(String[] args) {
        Mobile.f1();
        Plant.f1();
    }

}

class Mobile {
    static String brand = "Huawei";

    static void f1() {
        System.out.println(brand);
    }
}

class Plant {
    static String name;

    static {
        name = "scindapsus aureus[绿萝]";
    }

    static void f1() {
        System.out.println(name);
    }
}

