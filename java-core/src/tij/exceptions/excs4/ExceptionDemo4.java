package tij.exceptions.excs4;

public class ExceptionDemo4 {

    public static void main(String[] args) {
        try {
            throw new MyException("Hello, MyException");
        } catch (MyException e) {
            e.showMessage();
        }
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
