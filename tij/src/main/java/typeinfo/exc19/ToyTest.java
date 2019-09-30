package typeinfo.exc19;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ToyTest {

    static void printInfo(Class cc) {
        System.out.println("Class name: " + cc.getName() +
                " is interface? [" + cc.isInterface() + "]");
        System.out.println("Simple name: " + cc.getSimpleName());
        System.out.println("Canonical name : " + cc.getCanonicalName());
    }

    public static void main(String[] args) {

        Class c = null;
        /*try {
            c = Class.forName("typeinfo.exc19.FancyToy");
        } catch (ClassNotFoundException e) {
            System.out.println("Can’t find FancyToy");
            System.exit(1);
        }*/

        try {
            c = Class.forName("typeinfo.exc19.Toy");
        } catch (ClassNotFoundException e) {
            System.out.println("Can’t find Toy");
            System.exit(1);
        }

        try {
            Constructor constructor = c.getDeclaredConstructor(int.class);
            Object o = constructor.newInstance(10);
            System.out.println(o);
        } catch (Exception e) {
            e.printStackTrace();
        }

        printInfo(c);
        for (Class face : c.getInterfaces())
            printInfo(face);
        Class up = c.getSuperclass();
        Object obj = null;
        try {
            // Requires default constructor:
            obj = up.newInstance();
        } catch (InstantiationException e) {
            System.out.println("Cannot instantiate");
            System.exit(1);
        } catch (IllegalAccessException e) {
            System.out.println("Cannot access");
            System.exit(1);
        }
        printInfo(obj.getClass());
    }

}

interface HasBatteries {
}

interface Waterproof {
}

interface Shoots {
}

interface Light {
}

class Toy {
    // Comment out the following default constructor
// to see NoSuchMethodError from (*1*)

    private int price;

    Toy() {
    }

    Toy(int i) {
        this.price = i;
    }

    @Override
    public String toString() {
        return "Toy's price is " + price + " yuan.";
    }
}

class FancyToy extends Toy
        implements HasBatteries, Waterproof, Shoots, Light {
    FancyToy() {
        super(1);
    }
}
