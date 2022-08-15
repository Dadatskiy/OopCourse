package dada.oop.shapes_main;

import dada.oop.shapes.*;
import dada.oop.shapes.Rectangle;

import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static Shapes getShapeWithConformingAreaValue(Shapes[] shapes, int descendingValue) {
        Arrays.sort(shapes, Comparator.comparing(Shapes::getArea));
        return shapes[shapes.length - descendingValue];
    }

    public static Shapes getShapeWithConformingPerimeterValue(Shapes[] shapes, int descendingPerimeterValue) {
        Arrays.sort(shapes, Comparator.comparing(Shapes::getPerimeter));
        return shapes[shapes.length - descendingPerimeterValue];
    }

    public static void main(String[] args) {

        Triangle triangle = new Triangle(-6, 11, 4, 7, 10, 13);

        Square square = new Square(32);

        Rectangle rectangle = new Rectangle(400, 51);

        Circle circle = new Circle(21);

        Shapes[] shapes = new Shapes[8];

        shapes[0] = new Rectangle(51, 400);
        shapes[1] = square;
        shapes[2] = circle;
        shapes[3] = rectangle;
        shapes[4] = triangle;
        shapes[5] = new Circle(33);
        shapes[6] = new Square(32);
        shapes[7] = new Triangle(0, 10, 10, 0, 0, 0);

        int descendingAreaValue = 1;

        Shapes firstAreaShape = getShapeWithConformingAreaValue(shapes, descendingAreaValue);

        System.out.println("Фигура с максимальной площадью имеет следующие геометрические характеристики: ");
        System.out.println(firstAreaShape);

        int descendingPerimeterValue = 2;

        Shapes secondPerimeterShape = getShapeWithConformingPerimeterValue(shapes, descendingPerimeterValue);

        System.out.println("Фигура со вторым по величине периметром имеет следующие геометрические характеристики: ");
        System.out.println(secondPerimeterShape);
        System.out.println(shapes[7].equals(square));
    }
}