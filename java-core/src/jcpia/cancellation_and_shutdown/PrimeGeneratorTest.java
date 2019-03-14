package jcpia.cancellation_and_shutdown;

import java.math.BigInteger;
import java.util.List;

import static java.util.concurrent.TimeUnit.SECONDS;

public class PrimeGeneratorTest {

    public static void main(String[] args) throws InterruptedException {
        List<BigInteger> bigIntegers = aSecondOfPrimes();

        for (int i=0; i<bigIntegers.size(); i++){
            System.out.print(bigIntegers.get(i) + ", ");
            if (i > 0 && i%10 == 0)
                System.out.println("\n");
        }
    }

    static List<BigInteger> aSecondOfPrimes() throws InterruptedException {
        PrimeGenerator generator = new PrimeGenerator();
        new Thread(generator).start();

        try {
            SECONDS.sleep(1);
        }finally {
            generator.cancel();
        }

        return generator.get();
    }

}
