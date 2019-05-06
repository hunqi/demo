package tij.polymorphism;

public class Starship {

    private AlertStatus status = AlertStatus.NORMAL;

    void change(AlertStatus status1){
        status = status1;
    }

    @Override
    public String toString() {
        return "The starship is " + status.toString();
    }

    public static void main(String[] args) {
        Starship starship = new Starship();
        System.out.println(starship);

        starship.change(AlertStatus.ERROR);
        System.out.println(starship);

        starship.change(AlertStatus.CRITICAL);
        System.out.println(starship);
    }
}

enum AlertStatus {
    NORMAL,
    ERROR,
    CRITICAL
}
