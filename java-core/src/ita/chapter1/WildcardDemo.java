package ita.chapter1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class WildcardDemo {

    public static void main(String[] args) {
        Squre[] squres = new Squre[3];
        List<Squre> squreList = new ArrayList<>();
        List<Circle> circleList = new ArrayList<>();

        totalArea(squres);
//        totalArea(squreList); // compile error
        totalArea(squreList);
        totalArea(circleList);
    }

    static double totalArea(Collection<? extends Shape> arr){
        double total = 0;
        for (Shape s : arr)
            if (s != null)
                total += s.area();
        return total;
    }

    /*static double totalArea(Collection<Shape> arr) {
        double total = 0;
        for (Shape s : arr)
            if (s != null)
                total += s.area();
        return total;
    }*/

    static double totalArea(Shape[] arr) {
        double total = 0;
        for (Shape s : arr)
            if (s != null)
                total += s.area();
        return total;
    }

}

class Circle extends Shape {
    private double r;

    public void setR(double r) {
        this.r = r;
    }

    @Override
    double area() {
        return Math.PI*r*r;
    }
}

class Squre extends Shape {

    private double a;

    public void setA(double a) {
        this.a = a;
    }

    @Override
    double area() {
        return a * a;
    }
}

class Shape {
    double area() {
        return 0;
    }
}
