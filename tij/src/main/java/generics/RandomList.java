package generics;

import typeinfo.pets.Cat;
import typeinfo.pets.Mutt;
import typeinfo.pets.Pet;
import typeinfo.pets.Pug;

import java.util.ArrayList;
import java.util.Random;

public class RandomList<T> {
    private ArrayList<T> storage = new ArrayList<T>();
    private Random rand = new Random(47);

    public void add(T item) {
        storage.add(item);
    }

    public T select() {
        return storage.get(rand.nextInt(storage.size()));
    }

    public static void main(String[] args) {
        RandomList<Pet> rs = new RandomList<Pet>();
        for (int i=0;i<3;i++)
            rs.add(new Mutt("mutt" + (i+1)));
        for (int i=0;i<3;i++)
            rs.add(new Pug("pug" + (i+1)));
        for (int i=0;i<3;i++)
            rs.add(new Cat("cat" + (i+1)));

        for (int i = 0; i < 9; i++)
            System.out.print(rs.select() + " ");
    }
}
