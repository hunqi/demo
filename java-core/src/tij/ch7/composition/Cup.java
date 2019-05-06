package tij.ch7.composition;

public class Cup {
    String color;

    @Override
    public String toString() {
        if (null == color)
            color = "White";
        return "This is a " + color + " cup";
    }
}
