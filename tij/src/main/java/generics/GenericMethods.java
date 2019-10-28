package generics;

public class GenericMethods {
    public <X, Y, Z> void f(X x, Y y, Z z, String msg) {
        System.out.println(msg);
        System.out.printf("%-20s\t%-20s\t%-20s\n",
                x.getClass().getName(),
                y.getClass().getName(),
                z.getClass().getName());
    }

    public static void main(String[] args) {
        GenericMethods gm = new GenericMethods();
        gm.f("", 1, 1.0, "group1");
        gm.f(1.0F, 'c', gm, "group2");
//        gm.f("");
//        gm.f(1);
//        gm.f(1.0);
//        gm.f(1.0F);
//        gm.f('c');
//        gm.f(gm);
    }
}
