package tij.exceptions.excs2;

public class ExceptionDemo2 {

    public static void main(String[] args) {
        Fish fish = null;
        try {
            fish.swim();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Fish {
    void swim() {
        System.out.println("Fish is swimming.");
    }
}
