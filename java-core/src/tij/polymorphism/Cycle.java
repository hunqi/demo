package tij.polymorphism;

public class Cycle {
    void ride() {
        System.out.println("Ride cycle.");
    }

    public static void main(String[] args) {
        Cycle[] cycles = {new Unicycle(), new Bicycle(), new Tricycle()};
        for (Cycle c : cycles)
            c.ride();

        ((Unicycle)cycles[0]).balance();
        ((Bicycle)cycles[1]).balance();
//        ((Tricycle)cycles[1]).balance();
    }
}

class Unicycle extends Cycle {
    @Override
    void ride() {
        System.out.println("Ride unicycle.");
    }

    void balance() {
        System.out.println("It's hard to balance unicycle.");
    }
}

class Bicycle extends Cycle {
    @Override
    void ride() {
        System.out.println("Ride Bicycle.");
    }

    void balance() {
        System.out.println("It's hard to balance bicycle.");
    }
}

class Tricycle extends Cycle {
    @Override
    void ride() {
        System.out.println("Ride tricycle.");
    }
}
