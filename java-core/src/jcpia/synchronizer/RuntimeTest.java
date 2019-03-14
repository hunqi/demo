package jcpia.synchronizer;

public class RuntimeTest {

    public static void main(String[] args) {
        int count = Runtime.getRuntime().availableProcessors();
        System.out.println("Count of available processors is : " + count);
    }

}
