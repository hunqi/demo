package tij.polymorphism;

public abstract class Animal {

}

class Dog extends Animal {

    static void transform(){
        Animal animal = new Dog(){};
        ((Dog)animal).run();
    }

    void run(){
        System.out.println("run()");
    }

    public static void main(String[] args) {
        transform();
    }
}
