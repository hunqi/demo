package primarytype;

public class ByteDemo {

    public static void main(String[] args) throws InterruptedException {
        byte b = 0;
        /*
        for (;b<128;b++) {
            Thread.sleep(90);
            System.out.println(b);
        }*/

        b += 1000;
        System.out.printf("b=%d\n", b);

    }

}
