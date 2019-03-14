package jcpia;

public class SystemTest {

    public static void main(String[] args) {
        System.out.println(System.identityHashCode(new Person()));
        System.out.println(System.identityHashCode(new Person(75)));
    }

    static class Person {
        double weight;

        public Person() {
        }

        public Person(double weight) {
            this.weight = weight;
        }

        public double getWeight() {
            return weight;
        }

        public void setWeight(double weight) {
            this.weight = weight;
        }
    }

}
