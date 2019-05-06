package tij.ch5.initialization;

public class WrapperInitialization {

    public static void main(String[] args) {
        new Toy().price();
    }

}

class Toy {
    Integer price;
    void price(){
        System.out.println("price: "  + price);
    }
}
