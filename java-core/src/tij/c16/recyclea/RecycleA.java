package tij.c16.recyclea;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

public class RecycleA {

    public static void main(String[] args) {
        ArrayList<Trash> bin = new ArrayList<>();
        // fill up the trash bin
        for (int i = 0; i < 30; i++) {
            switch ((int) (Math.random() * 3)) {
                case 0:
                    bin.add(new Aluminum(Math.random() * 100));
                    break;
                case 1:
                    bin.add(new Paper(Math.random() * 100));
                    break;
                case 2:
                    bin.add(new Glass(Math.random() * 100));
            }
        }

        ArrayList<Trash>
                alBin = new ArrayList<>(),
                paperBin = new ArrayList<>(),
                glassBin = new ArrayList<>();

        Iterator<Trash> sorter = bin.iterator();
        while (sorter.hasNext()) {
            Trash t = sorter.next();
            if (t instanceof Aluminum)
                alBin.add(t);
            else if (t instanceof Paper)
                paperBin.add(t);
            else if (t instanceof Glass)
                glassBin.add(t);
        }

        Trash.sumValue(alBin);
        Trash.sumValue(paperBin);
        Trash.sumValue(glassBin);
        Trash.sumValue(bin);
    }
}

abstract class Trash {
    private double weight;

    Trash(double wt) {
        weight = wt;
    }

    abstract double value();

    double weight() {
        return weight;
    }

    // Sums the value of Trash in a bin
    static void sumValue(ArrayList<Trash> bin) {
        Iterator<Trash> ite = bin.iterator();
        double val = 0;

        while (ite.hasNext()) {
            Trash t = ite.next();
            val += t.weight() * t.value();
            System.out.println("weight of " + t.getClass().getName() + " = " + t.weight());
        }
        System.out.println("Total value = " + val);
    }

}

class Aluminum extends Trash {

    static double val = 1.67;

    Aluminum(double wt) {
        super(wt);
    }

    @Override
    double value() {
        return val;
    }

    static void value(double newVal) {
        val = newVal;
    }
}

class Paper extends Trash {

    static double val = 0.10;

    Paper(double wt) {
        super(wt);
    }

    @Override
    double value() {
        return val;
    }

    static void value(double newVal) {
        val = newVal;
    }
}

class Glass extends Trash {
    static double val = 0.23;

    Glass(double wt) {
        super(wt);
    }

    @Override
    double value() {
        return val;
    }

    static void value(double newVal) {
        val = newVal;
    }
}

