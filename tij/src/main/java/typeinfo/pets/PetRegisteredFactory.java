package typeinfo.pets;

import typeinfo.factory.Factory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PetRegisteredFactory extends PetCreator {

    private Random rand = new Random(47);
    private static List<Factory<Pet>> factories = new ArrayList<>();

    static {
        factories.add(() -> new Pet());
        factories.add(() -> new Dog());
        factories.add(() -> new Cat());
        factories.add(() -> new Rodent());
        factories.add(() -> new Mutt());
        factories.add(() -> new Pug());
        factories.add(() -> new EgyptianMau());
        factories.add(() -> new Manx());
        factories.add(() -> new Cymric());
        factories.add(() -> new Rat());
        factories.add(() -> new Mouse());
        factories.add(() -> new Hamster());
        factories.add(() -> new Gerbil());
    }

    @Override
    public Pet randomPet() {
        int n = rand.nextInt(factories.size());
        return factories.get(n).create();
    }

    @Override
    public List<Class<? extends Pet>> types() {
        return null;
    }

}
