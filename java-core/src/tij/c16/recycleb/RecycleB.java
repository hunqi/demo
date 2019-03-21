package tij.c16.recycleb;

import java.util.*;

public class RecycleB {

    public static void main(String[] args) {
        ArrayList<Trash> bin = new ArrayList<>();
        int typeNumber = TrashType.values().length - 1;

        // fill up the trash bin
        for (int i = 0; i < 30; i++) {
            bin.add(new Trash(Math.random() * 100, TrashType.getById((int) (Math.random() * typeNumber))));
        }

        Map<TrashType, List<Trash>> sortedBin = new HashMap<>();
        Set<TrashType> trashTypes = sortedBin.keySet();

        Iterator<Trash> sorter = bin.iterator();
        while (sorter.hasNext()) {
            Trash t = sorter.next();
            if (!trashTypes.contains(t.type())) {
                sortedBin.put(t.type(), new ArrayList<Trash>());
            }
            sortedBin.get(t.type()).add(t);
        }

        for (TrashType t : trashTypes)
            Trash.sumValue(sortedBin.get(t));

        Trash.sumValue(bin);
    }
}

class Trash {
    private double weight;
    private TrashType type;

    Trash(double wt) {
        weight = wt;
    }

    Trash(double weight, TrashType type) {
        this.weight = weight;
        this.type = type;
    }

    double value() {
        return type.val();
    }

    double weight() {
        return weight;
    }

    TrashType type() {
        return type;
    }

    // Sums the value of Trash in a bin
    static void sumValue(List<Trash> bin) {
        Iterator<Trash> ite = bin.iterator();
        double val = 0;

        while (ite.hasNext()) {
            Trash t = ite.next();
            val += t.weight() * t.value();
            System.out.println("weight of " + t.type.name() + " = " + t.weight());
        }
        System.out.println("Total value = " + val);
    }

}

enum TrashType {
    ALUMINUM(0, "Aluminum", 1.67),
    PAPER(1, "Paper", 0.10),
    GLASS(2, "Glass", 0.23),
    CARDBOARD(3, "Cardboard", 0.23),
    STEEL(4, "Steel", 0.60),
    INVALID(100, "Invalid_Type", 0);

    private int id;
    private String name;
    private double val;

    TrashType(int id, String name, double val) {
        this.id = id;
        this.name = name;
        this.val = val;
    }

    public double val() {
        return val;
    }

    public static TrashType getById(int id) {
        for (TrashType t : TrashType.values())
            if (t.id == id)
                return t;
        return INVALID;
    }

}