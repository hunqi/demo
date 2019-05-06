package tij.reusing;

import java.util.Random;

public class DemonstrateFinalAndStatic {
    static Random random = new Random();
    final int rate = random.nextInt(100);
    static final int PRICE = random.nextInt(100);

    private String name;

    public DemonstrateFinalAndStatic(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name + ": rate=" + rate + ", PRICE=" + PRICE;
    }

    public static void main(String[] args) {
        DemonstrateFinalAndStatic d1 = new DemonstrateFinalAndStatic("d1");
        DemonstrateFinalAndStatic d2 = new DemonstrateFinalAndStatic("d2");

        System.out.println(d1);
        System.out.println(d2);
    }
}
