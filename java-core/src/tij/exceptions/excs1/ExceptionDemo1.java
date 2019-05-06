package tij.exceptions.excs1;

public class ExceptionDemo1 {

    public static void main(String[] args) {

        try {
            throw new Exception("Hello, Exception.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Exception handled.");
        }

    }

}
