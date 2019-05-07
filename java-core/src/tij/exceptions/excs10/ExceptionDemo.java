package tij.exceptions.excs10;

public class ExceptionDemo {

    static void g() throws OneException {
        System.out.println("Originating the exception in g();");
        throw new OneException();
    }

    static void f() throws TwoException {
        try {
            g();
        } catch (OneException e) {
//            e.printStackTrace(System.out);
            System.out.println("Caught in f();");
            TwoException te = new TwoException();
            te.initCause(e);
            throw te;
        }
    }

    public static void main(String[] args) {
        try {
            f();
        } catch (TwoException e) {
            System.out.println("Caught in main();");
            e.printStackTrace(System.out);
        }
    }

}

class OneException extends Exception {}

class TwoException extends Exception {}
