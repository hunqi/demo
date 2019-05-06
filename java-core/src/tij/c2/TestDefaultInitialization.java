package tij.c2;

public class TestDefaultInitialization {

    public static void main(String[] args) {
        Size s = new Size();
        System.out.println("Default size.value=" + s.value + ", size.flag=" + s.flag);
    }

}

class Size {
    int value;
    char flag;
}
