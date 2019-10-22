package generics.coffee;

import typeinfo.factory.Factory;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

// Generate different types of Coffee:
public class CoffeeGenerator implements Generator<Coffee>, Iterable<Coffee> {
    private Class[] types = {Latte.class, Mocha.class,
            Cappuccino.class, Americano.class, Breve.class,};


//    private static List<Factory<Coffee>> factories = new ArrayList<>();
//
//    static {
//        factories.add(() -> new Latte());
//        factories.add(() -> new Mocha());
//        factories.add(() -> new Cappuccino());
//        factories.add(() -> new Americano());
//        factories.add(() -> new Breve());
//    }

    private static Random rand = new Random(47);

    public CoffeeGenerator() {
    }

    // For iteration:
    private int size = 0;

    public CoffeeGenerator(int sz) {
        size = sz;
    }

    public Coffee next() {
        try {
            return (Coffee)
                    types[rand.nextInt(types.length)].newInstance();
            // Report programmer errors at run time:
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
//        return factories.get(rand.nextInt(factories.size())).create();
    }

    class CoffeeIterator implements Iterator<Coffee> {
        int count = size;

        public boolean hasNext() {
            return count > 0;
        }

        public Coffee next() {
            count--;
            return CoffeeGenerator.this.next();
        }

        public void remove() { // Not implemented
            throw new UnsupportedOperationException();
        }
    }

    @Override
    public Iterator<Coffee> iterator() {
        return new CoffeeIterator();
    }

    public static void main(String[] args) {
        CoffeeGenerator gen = new CoffeeGenerator();
        for (int i = 0; i < 5; i++)
            System.out.println(gen.next());
        System.out.println("------");
        for (Coffee c : new CoffeeGenerator(5))
            System.out.println(c);
    }
}
