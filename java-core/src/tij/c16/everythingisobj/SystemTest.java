package tij.c16.everythingisobj;

public class SystemTest {

    public static void main(String[] args) {

        System.getProperties().list(System.out);
        System.out.println(System.getProperty("user.name"));
        System.out.println(System.getProperty("java.library.path"));

    }

}
