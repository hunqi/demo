package typeinfo;

import java.util.Arrays;
import java.util.List;

abstract class Shape {

    String highlight = "";

    void draw() {
        System.out.println(this + ".draw()");
    }

    void setHighlight(String highlight) {
        this.highlight = highlight;
    }

    String getHighlight() {
        return highlight;
    }

    abstract public String toString();
}

class Circle extends Shape {
    public String toString() {
        return getHighlight() + "Circle";
    }
}

class Square extends Shape {
    public String toString() {
        return getHighlight() + "Square";
    }
}

class Triangle extends Shape {
    public String toString() {
        return getHighlight() + "Triangle";
    }
}

class Rhomboid extends Shape {
    public String toString() {
        return getHighlight() + "Rhomboid";
    }
}

public class Shapes {

    public static void main(String[] args) {
        List<Shape> shapeList = Arrays.asList(
                new Circle(), new Triangle(), new Square(), new Triangle()
        );
        System.out.println("Draw the shapes.");
        for (Shape shape : shapeList)
            shape.draw();

        Shape s = new Rhomboid();
        s.draw();

        Circle c = null;
        if (s instanceof Circle)
            c = (Circle) s;
        System.out.println(c);

        System.out.println("Rotate the shapes except circle:");
        for (Shape shape : shapeList)
            rotate(shape);

        System.out.println("Highlight all triangles:");
        for (Shape shape : shapeList)
            if (shape instanceof Triangle)
                highlight(shape);

        for (Shape shape : shapeList)
            shape.draw();
    }

    static void rotate(Shape shape) {
        if (shape instanceof Circle)
            System.out.println("Not rotate as it's a circle");
        else
            System.out.println("Rotate " + shape);
    }

    static void highlight(Shape shape) {
        shape.setHighlight("Highlighted ");
    }

}