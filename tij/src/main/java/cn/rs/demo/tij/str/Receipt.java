package cn.rs.demo.tij.str;

import java.util.Formatter;

public class Receipt {

    private double total = 0;
    private Formatter f = new Formatter(System.out);
    int width1 = 15, width2 = 5, width3 = 10;

    public void printTitle() {
        String pattern = "%-" + width1 + "s %" + width2 + "s %" + width3 + "s%n";
        f.format(pattern, "Item", "Qty", "Price");
        f.format(pattern, "----", "---", "-----");
    }

    public void print(String name, int qty, double price) {
        f.format("%-15.15s %5d %10.2f%n", name, qty, price);
        total += price;
    }

    public void printTotal() {
        f.format("%-15s %5s %10.2f%n", "Tax", "", total * 0.06);
        f.format("%-15s %5s %10s%n", "", "", "-----");
        f.format("%-15s %5s %10.2f%n", "Total", "",
                total * 1.06);
    }

    public static void main(String[] args) {
        Receipt receipt = new Receipt();
        receipt.printTitle();
        receipt.print("Jack’s Magic Beans", 4, 4.25);
        receipt.print("Princess Peas", 3, 5.1);
        receipt.print("Three Bears Porridge", 1, 14.29);
        receipt.printTotal();
    }

}

class Receipt2 {

    public static void main(String[] args) {
        int[] widths = {15, 5, 10};
        String p1 = "%s%ds %s%ds %s%ds%n";
        String p2 = String.format(p1, "%-", widths[0], "%", widths[1], "%", widths[2]);
        System.out.println(p2);

        Formatter f = new Formatter(System.out);
        f.format(p2, "Item", "Qty", "Price");
        f.format(p2, "----", "---", "-----");
    }

}

/**
 * Exercise 4: (3) Modify Receipt.java so that the widths are all controlled by a single set of constant values.
 * The goal is to allow you to easily change a width by changing a single value in one place.
 */
class Receipt3 {
    private double total = 0;
    private Formatter f = new Formatter(System.out);
    private int[] widths = {15, 5, 10};
    private String p = "%s%ds %s%ds %s%ds%n";
    // p1 like "%-15s %5s %10s\n"
    private String p1 = String.format(p, "%-", widths[0], "%", widths[1], "%", widths[2]);

    public void printTitle() {
        f.format(p1, "Item", "Qty", "Price");
        f.format(p1, "----", "---", "-----");
    }

    public void print(String name, int qty, double price) {
        // p2 = "%-15.15s %5d %10.2f%n"
        String p2 = String.format("%s%d.%ds %s%ds %s%d.2f%n", "%-", widths[0], widths[0], "%", widths[1], "%", widths[2]);
        f.format(p2, name, qty, price);
        total += price;
    }

    public void printTotal() {
        // p3 = "%-15s %5s %10.2f%n"
        String p3 = String.format("%s%ds %s%ds %s%d.2f%n", "%-", widths[0], "%", widths[1], "%", widths[2]);
        f.format(p3, "Tax", "", total * 0.06);
        f.format(p1, "", "", "-----");
        f.format(p3, "Total", "", total * 1.06);
    }

    public static void main(String[] args) {
        Receipt3 receipt3 = new Receipt3();
        receipt3.printTitle();
        receipt3.print("Jack’s Magic Beans", 4, 4.25);
        receipt3.print("Princess Peas", 3, 5.1);
        receipt3.print("Three Bears Porridge", 1, 14.29);
        receipt3.printTotal();
    }
}
