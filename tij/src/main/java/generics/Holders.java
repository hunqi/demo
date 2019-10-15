package generics;

import typeinfo.pets.Dog;
import typeinfo.pets.Mutt;
import typeinfo.pets.Pug;

public class Holders {

    private Dog dog1;
    private Dog dog2;
    private Dog dog3;

    Holders(Dog _1stDog, Dog _2ndDog, Dog _3rdDog) {
        dog1 = _1stDog;
        dog2 = _2ndDog;
        dog3 = _3rdDog;
    }

    void setDog1(String name) {
        dog1.setName(name);
    }

    void setDog2(String name) {
        dog2.setName(name);
    }

    void setDog3(String name) {
        dog3.setName(name);
    }

    public Dog getDog1() {
        return dog1;
    }

    public Dog getDog2() {
        return dog2;
    }

    public Dog getDog3() {
        return dog3;
    }

    public static void main(String[] args) {

        Holders dogCage = new Holders(new Mutt(), new Pug(), new Pug());
        dogCage.setDog1("mutt1");
        dogCage.setDog2("pug1");
        dogCage.setDog3("pug2");

        System.out.println(dogCage.dog1);
        System.out.println(dogCage.dog2);
        System.out.println(dogCage.dog3);
    }
}
