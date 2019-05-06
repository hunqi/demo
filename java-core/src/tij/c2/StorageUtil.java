package tij.c2;

public class StorageUtil {

    public static void main(String[] args) {
        String s = "hello, world";
        System.out.println("s needs storage space " + storage(s));
    }

    private static int storage(String s) {
        return s.length() * 2;
    }

}
