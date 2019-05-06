package tij.reusing.excs16;

public class Frog extends Amphibian {

    @Override
    void liveInWater() {
        System.out.print("Gwa, I'm a frog, ");
        super.liveInWater();
    }

    public static void main(String[] args) {

        Amphibian amphibian = new Frog();
        amphibian.liveInWater();
        amphibian.liveOnLand();

    }

}
