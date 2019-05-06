package tij.innerclasses.excs15;

public class CupFactory {

    public Cup getCup(String material) {
        return new Cup(material) {
        };
    }

    public static void main(String[] args) {
        CupFactory factory = new CupFactory();
        factory.getCup("glass");
    }

}
