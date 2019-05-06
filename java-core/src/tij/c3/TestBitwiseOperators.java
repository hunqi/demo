package tij.c3;

public class TestBitwiseOperators {

    public static void main(String[] args) {
        int a = 0x55555;
        System.out.println(Integer.toBinaryString(a));  // 1010101010101010101
        int b = ~a;
        System.out.println(Integer.toBinaryString(b));  // 111111111111 10101010101010101010

        System.out.println("a=" + a + ", b=" + b);
        System.out.println(~a);
        System.out.println(~b);
        System.out.println(a & b);
        System.out.println(a | b);
        System.out.println(a ^ b);
    }

}
