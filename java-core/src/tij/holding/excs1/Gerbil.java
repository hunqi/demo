package tij.holding.excs1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Gerbil  ['dʒɜːbɪl] n. [脊椎] 沙鼠（南非传播鼠疫的啮齿动物）
 */
public class Gerbil {

    private int gerbilNumber;

    public Gerbil(int gerbilNumber) {
        this.gerbilNumber = gerbilNumber;
    }

    // hop v. 单足跳跃〔跳行〕 vi. 双足或齐足跳行
    void hop() {
        System.out.println("Gerbil_" + gerbilNumber + " hop.");
    }

    public static void main(String[] args) {

        List<Gerbil> list = new ArrayList<>();
        list.addAll(Arrays.asList(new Gerbil(1), new Gerbil(2), new Gerbil(3),
                new Gerbil(4), new Gerbil(5)));

        for (Gerbil g : list)
            g.hop();
    }

}
