package generics.character;

import util.Generator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class CharacterGenerator implements Generator<Character>, Iterable<Character> {

    private Class[] types = {QiaoFeng.class, DuanYu.class, XuZu.class,
            KangMin.class, QuanGuanQing.class, DingChunQiu.class};

    private static Random rand = new Random(46);

    private int size = 0;

    public CharacterGenerator() {
    }

    public CharacterGenerator(int sz) {
        size = sz;
    }

    @Override
    public Character next() {
        try {
            return (Character)
                    types[rand.nextInt(types.length)].newInstance();
            // Report programmer errors at run time:
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    class CharacterIterator implements Iterator<Character> {
        int count = size;

        @Override
        public boolean hasNext() {
            return count > 0;
        }

        @Override
        public Character next() {
            count--;
            return CharacterGenerator.this.next();
        }
    }

    @Override
    public Iterator<Character> iterator() {
        return new CharacterIterator();
    }

    public static void main(String[] args) {
        CharacterGenerator characterGenerator = new CharacterGenerator();
        List<GoodGuy> goodGuys = new ArrayList<>();
        List<BadGuy> badGuys = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Character c = characterGenerator.next();
            System.out.println(c);
            if (c instanceof GoodGuy) goodGuys.add((GoodGuy) c);
            else badGuys.add((BadGuy) c);
        }

        System.out.printf("Good guys: %s\n", goodGuys);
        System.out.printf("Bad guys: %s\n", badGuys);
    }
}
