package tij.exceptions.excs8;

public class ExceptionSpecificationDemo {

    static void f(){
        try {
            throw new MyException("MyException occurred.");
        } catch (MyException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        f();

    }


}

class MyException extends Exception {

    private String message;

    MyException(String msg){
        this.message = msg;
    }

    void showMessage(){
        System.out.println(message);
    }

}
