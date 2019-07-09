package cn.rs.demo.tij.str;

public class SimpleFormat {

    public static void main(String[] args) {

        int x = 5;
        double y = 5.55555;

        System.out.println("Row 1: [" + x + " " + y + "]");
        System.out.format("Row 1: [%d %f]%n", x, y);
        System.out.printf("Row 1: [%d %f]%n", x, y);
    }

}
