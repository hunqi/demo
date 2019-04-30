package tij.holding.excs17;

import java.util.*;

/**
 * Gerbil  ['dʒɜːbɪl] n. [脊椎] 沙鼠（南非传播鼠疫的啮齿动物）
 */
public class Gerbil {

    private int gerbilNumber;
    private String name;

    public Gerbil(int gerbilNumber, String name) {
        this.gerbilNumber = gerbilNumber;
        this.name = name;
    }

    // hop v. 单足跳跃〔跳行〕 vi. 双足或齐足跳行
    void hop() {
        System.out.println("Gerbil_" + gerbilNumber + " hop.");
    }

    public int getGerbilNumber() {
        return gerbilNumber;
    }

    public String getName() {
        return name;
    }

    public static void main(String[] args) {

        Map<String, Gerbil> map = new HashMap<>();
        map.put("Fuzzy", new Gerbil(1, "Fuzzy"));
        map.put("Spot", new Gerbil(2, "Spot"));

        Iterator<String> iterator = map.keySet().iterator();

        while (iterator.hasNext()){
            String key = iterator.next();
            Gerbil gerbil = map.get(key);
            System.out.print(key + "\t");
            gerbil.hop();
        }
    }

}
