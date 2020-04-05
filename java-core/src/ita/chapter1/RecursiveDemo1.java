package ita.chapter1;

public class RecursiveDemo1 {

    public static void main(String[] args) {
        printOut(12345);
    }

    static void printOut(int n){
        if (n >= 10)
            printOut(n / 10);
        System.out.printf("%d", n % 10);
    }

}
