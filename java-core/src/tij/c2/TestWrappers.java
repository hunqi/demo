package tij.c2;

public class TestWrappers {

    public static void main(String[] args) {

        int a = 1;
        Integer a1 = a;
        System.out.println(a1);

        Integer a2 = new Integer(a);
        System.out.println(a2);

        boolean b = false;
        Boolean b1 = b;
        System.out.println(b1);
        Boolean b2 = new Boolean(false);
        System.out.println(b2);

        char c = 'c';
        Character c1 = c;
        System.out.println(c1);
        Character c2 = new Character(c);
        System.out.println(c2);
    }

}
