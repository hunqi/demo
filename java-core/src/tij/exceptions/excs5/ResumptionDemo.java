package tij.exceptions.excs5;

public class ResumptionDemo {

    public static void main(String[] args) {

        int threshold = 10;
        int counter = 0;
        while (counter < 10) {
            counter++;
            try {
                throw new Exception("Not satisfy the threshold");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            try {
                Thread.sleep(150);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println();
        System.out.println("Done");
    }

}
