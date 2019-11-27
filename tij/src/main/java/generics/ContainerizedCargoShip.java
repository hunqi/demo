package generics;

import util.Generator;
import util.Generators;

import java.util.ArrayList;
import java.util.Random;

/**
 * containerized cargo ship 集装箱货运船
 * container 集装箱
 * deck 甲板
 * cabin 船舱
 * cuddy 小船室
 */
public class ContainerizedCargoShip {

    Deck deck;
    Cabin cabin;

    public ContainerizedCargoShip(int nCuddies, int nContainers) {
        deck = new Deck(nCuddies, nContainers);
        cabin = new Cabin(nCuddies, nContainers);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Cuddy c : deck)
            for (Container ct : c)
                sb.append(ct).append("\n");
        for (Cuddy c : cabin)
            for (Container ct : c)
                sb.append(ct).append("\n");

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new ContainerizedCargoShip(5, 5));
    }
}

class Deck extends ArrayList<Cuddy> {
    public Deck(int nCuddies, int nContainers) {
        for (int i = 0; i < nCuddies; i++)
            add(new Cuddy(nContainers));
    }
}

class Cabin extends ArrayList<Cuddy> {
    public Cabin(int nCuddies, int nContainers) {
        for (int i = 0; i < nCuddies; i++)
            add(new Cuddy(nContainers));
    }
}

class Cuddy extends ArrayList<Container> {
    public Cuddy(int nContainers) {
        Generators.fill(this, Container.generator, nContainers);
    }
}

class Container {
    GoodsCategory goodsCategory;
    Material material;

    public Container(GoodsCategory goodsCategory, Material material) {
        this.goodsCategory = goodsCategory;
        this.material = material;
    }

    public static Generator<Container> generator = new Generator<Container>() {

        private Random rand = new Random(47);

        @Override
        public Container next() {
            return new Container(GoodsCategory.values()[rand.nextInt(GoodsCategory.values().length)],
                    Material.values()[rand.nextInt(Material.values().length)]);
        }
    };

    @Override
    public String toString() {
        return "gc: " + goodsCategory + ", m: " + material;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++)
            System.out.println(generator.next());
    }
}

enum GoodsCategory {
    DRY,            /* 干货 */
    BULK,           /* 散货 */
    LIQUID,
    COLD_STORAGE,   /* 冷藏品 */
    CAR,
    LIVESTOCK,      /* 牲畜 */
    HIDE            /* 兽皮 */
}

enum Material {
    STEEL,          /* 钢制 */
    ALUMINIUM,      /* 铝 */
    REINFORCED,     /* 玻璃钢 */
    WOOD,           /* 木材 */
    STAINLESS_STEEL /* 不锈钢 */
}
