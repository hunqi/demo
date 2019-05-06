package tij.innerclasses.excs23;

public class B {

    private static U[] us = new U[10];

    public void add(U au) {
        for (int i=0,len=us.length;i<len;i++) {
            if (us[i] == null) {
                us[i] = au;
                return;
            }
        }

        System.out.println("The array is full");
    }

    public void remove(int index) {
        if (index >= 0 && index < len()) {
            us[index] = null;
        } else {
            System.out.println("Index out of bounds");
        }
    }

    public void invokeAll() {
        for (U u : us) {
            if (u != null) {
                u.f();
                u.f2();
                u.f3();
            }
        }
    }

    private int len() {
        int length = 0;
        for (U u : us) {
            if (u != null)
                length++;
        }
        return length;
    }

    public static void main(String[] args) {
        B b = new B();
        A a = new A();
        b.add(a.createU());
        b.add(a.createU());
        b.add(a.createU());

        b.invokeAll();
        System.out.println();

        b.remove(0);
        b.remove(1);

        b.invokeAll();
    }

}
