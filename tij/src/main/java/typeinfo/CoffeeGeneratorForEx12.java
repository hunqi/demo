package typeinfo;

import generics.coffee.*;
import util.TypeCounter;

import java.util.Iterator;
import java.util.Random;

/**
 * Exercise 12: (3) Use TypeCounter with the CoffeeGenerator.java class in the Generics chapter.
 */
public class CoffeeGeneratorForEx12 {
    private Class[] types = {Latte.class, Mocha.class,
            Cappuccino.class, Americano.class, Breve.class,};

    private static Random rand = new Random(47);

    public CoffeeGeneratorForEx12() {
    }

    // For iteration:
    private int size = 0;

    public CoffeeGeneratorForEx12(int sz) {
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
    }

    class CoffeeIterator implements Iterator<Coffee> {
        int count = size;

        public boolean hasNext() {
            return count > 0;
        }

        public Coffee next() {
            count--;
            return CoffeeGeneratorForEx12.this.next();
        }

        public void remove() { // Not implemented
            throw new UnsupportedOperationException();
        }
    }

//    @Override
    public Iterator<Coffee> iterator() {
        return new CoffeeGeneratorForEx12.CoffeeIterator();
    }

    public static void main(String[] args) {
        TypeCounter typeCounter = new TypeCounter(Coffee.class);
        CoffeeGenerator gen = new CoffeeGenerator();
        for (int i = 0; i < 5; i++){
            Coffee tmpCoffee = gen.next();
            typeCounter.count(tmpCoffee);
            System.out.println(tmpCoffee);
        }
        System.out.println(typeCounter);

        System.out.println("------");
        for (Coffee c : new CoffeeGenerator(5)){
            typeCounter.count(c);
            System.out.println(c);
        }
        System.out.println(typeCounter);
    }
}
