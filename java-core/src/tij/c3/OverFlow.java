package tij.c3;

public class OverFlow {

    public static void main(String[] args) {
        int big = Integer.MAX_VALUE;
        System.out.println("big=" + big);
        int bigger = 6 * big;
        System.out.println("bigger=" + bigger);
    }

}
