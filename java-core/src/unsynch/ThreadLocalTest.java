package unsynch;

import java.util.Date;

public class ThreadLocalTest {

    public static void main(String[] args) {
        ThreadLocal<Date> dateThreadLocal = new ThreadLocal<Date>(){
            @Override
            protected Date initialValue() {
                return new Date();
            }
        };

        System.out.println(dateThreadLocal.get());
    }

}
