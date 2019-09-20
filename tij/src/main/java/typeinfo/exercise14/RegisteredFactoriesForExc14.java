package typeinfo.exercise14;

import util.TypeCounter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Exercise 14: (4) A constructor is a kind of factory method.
 * Modify RegisteredFactories.java so that instead of using an explicit factory,
 * the class object is stored in the List, and newlnstance( ) is used to create each object.
 */
public class RegisteredFactoriesForExc14 {

    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        TypeCounter typeCounter = new TypeCounter(Part.class);
        for (int i = 0; i < 10; i++) {
            Part p = Part.createRandom();
            typeCounter.count(p);
            System.out.println(p);
        }
        System.out.println(typeCounter);
    }

}

class Part {
    public String toString() {
        return getClass().getSimpleName();
    }

    static List<Class<? extends Part>> partFactories = Arrays.asList(
            FuelFilter.class,
            AirFilter.class,
            CabinAirFilter.class,
            OilFilter.class,
            FanBelt.class,
            PowerSteeringBelt.class,
            GeneratorBelt.class);

    private static Random rand = new Random(47);

    public static Part createRandom() throws IllegalAccessException, InstantiationException {
        int n = rand.nextInt(partFactories.size());
        return partFactories.get(n).newInstance();
    }
}

class Filter extends Part {
}

class FuelFilter extends Filter {
}

class AirFilter extends Filter {
}

class CabinAirFilter extends Filter {
}

class OilFilter extends Filter {
}

class Belt extends Part {
}

class FanBelt extends Belt {
}

class GeneratorBelt extends Belt {
}

class PowerSteeringBelt extends Belt {
}
