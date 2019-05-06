package tij.ch7.inheritence;

public class Cartoon extends Drawing {
    public Cartoon(String name) {
        System.out.println("Cartoon(" + name + ")");
    }

    public static void main(String[] args) {
        Cartoon x = new Cartoon("Tom&Jerry");
    }
}

class Art {
    Art() {
        System.out.println("Art()");
    }
}

class Drawing extends Art {
    Drawing() {
        System.out.println("Drawing()");
    }
}
