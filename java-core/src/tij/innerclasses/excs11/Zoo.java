package tij.innerclasses.excs11;

public class Zoo {

    // Swan tian'e
    private class Swan implements Bird {

        @Override
        public void fly() {
            System.out.println("Swan.fly()");
        }
    }

    public Bird seeBird(){
        System.out.println("You will see a bird:");
        return new Swan();
    }

    public Bird seeNewBird(){
        System.out.println("You will see a new bird:");
        return new Bird() {
            @Override
            public void fly() {
                System.out.println("unknow-bird.fly()");
            }
        };
    }

    public static void main(String[] args) {
        Zoo zoo = new Zoo();
//        zoo.seeBird().fly();
        zoo.seeNewBird().fly();
    }

}

interface Bird {
    void fly();
}
