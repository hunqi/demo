package jvm.ch8;

public class LocalVariableTest {

    public static void main(String[] args) {
//        byte[] placeholder = new byte[64*1024*1024];
//        System.gc();

        {
            byte[] placeholder = new byte[64 * 1024 * 1024];
        }

        // gc succeed after "int a = 0;" added
        int a = 0;
        System.gc();
    }

}
