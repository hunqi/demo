package tij.holding.excs4;

import java.util.*;

public class CharacterNameGenerator {

    static List<String> charactersList = Arrays.asList(
            "Snow White", "Doc", "Bashful", "Sleepy",
            "Sneezy", "Happy", "Dopey", "Grumpy");

    static int currentIndex = -1;

    public static String next(){
        if (currentIndex == charactersList.size() - 1)
            currentIndex = -1;

        currentIndex++;
        return charactersList.get(currentIndex);
    }
}

class CollectionTest {

    public static void main(String[] args) {

        List<String> aList = new ArrayList<>();
        List<String> lList = new LinkedList<>();
        Set<String> hSet = new HashSet<>();
        Set<String> lhSet = new LinkedHashSet<>();
        Set<String> tSet = new TreeSet<>();

        for (int i=0; i<4; i++)
            aList.add(CharacterNameGenerator.next());

        for (int i=0; i<5; i++)
            lList.add(CharacterNameGenerator.next());

        for (int i=0; i<6; i++)
            hSet.add(CharacterNameGenerator.next());

        for (int i=0; i<7; i++)
            lhSet.add(CharacterNameGenerator.next());

        for (int i=0; i<8; i++)
            tSet.add(CharacterNameGenerator.next());

        System.out.println("aList: " + aList);
        System.out.println();

        System.out.println("lList: " + lList);
        System.out.println();

        System.out.println("hSet: " + hSet);
        System.out.println();

        System.out.println("lhSet: " + lhSet);
        System.out.println();

        System.out.println("tSet: " + tSet);

    }

}
