package streams;

import java.util.Optional;

public class OptionalTest {

    public static void main(String[] args) {
        //ifPresent
        doSomething("").ifPresent(t -> System.out.println("Execute task: " + t));
        doSomething("cooking").ifPresent(t -> System.out.println("Execute task: " + t));

        //orElse
        System.out.println("optionalS: " + optionalString().orElse("empty"));
        //orElseGet
        System.out.println("optionalS2: " + optionalString().orElseGet(() -> defaultStr()));
        //orElseThrow
        try {
            System.out.println("optionalS3: " + optionalString().orElseThrow(IllegalArgumentException::new));
        } catch (IllegalArgumentException e) {
            System.out.println("optionalS3: IllegalArgumentException caught");
        }


    }

    static String defaultStr() {
        return "N/A";
    }

    static Optional<String> doSomething(String s) {
        if (null == s || s.length() == 0) return Optional.empty();
        return Optional.of(s);
    }

    static Optional<String> optionalString() {
        double factor = Math.random();
        if (factor >= 0.5)
            return Optional.of("greater");
        return Optional.empty();
    }


}
