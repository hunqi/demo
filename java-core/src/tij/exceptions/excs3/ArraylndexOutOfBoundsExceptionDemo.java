package tij.exceptions.excs3;

public class ArraylndexOutOfBoundsExceptionDemo {

    public static void main(String[] args) {
        String[] cities = {"Shenzhen", "Tianjin"};

        try {
            System.out.println(cities[3]);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
