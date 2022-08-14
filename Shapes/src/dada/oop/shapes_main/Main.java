package dada.oop.shapes_main;

import dada.oop.shapes.*;
import dada.oop.shapes.Rectangle;

import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static Shapes getShapeWithConformingAreaValue(Shapes[] shapes, int descendingValue) {
        Arrays.sort(shapes, Comparator.comparing(Shapes::getArea));
        return shapes[shapes.length-descendingValue];
    }

    public static Shapes getShapeWithConformingPerimeterValue(Shapes[] shapes, int descendingValue) {
        Arrays.sort(shapes, Comparator.comparing(Shapes::getPerimeter));
        return shapes[shapes.length-descendingValue];
    }

    public static void main(String[] args) {
        Triangle triangle = new Triangle(-6, 11, 4, 7, 10, 13);

        Square square = new Square(32);

        Rectangle rectangle = new Rectangle(40, 11);

        Circle circle = new Circle(21);

        Shapes[] shapes = new Shapes[8];

        shapes[0] = new Rectangle(11, 15);
        shapes[1] = square;
        shapes[2] = circle;
        shapes[3] = rectangle;
        shapes[4] = triangle;
        shapes[5] = new Circle(33);
        shapes[6] = new Square(22);
        shapes[7] = new Triangle(0, 10, 0, 15, 0, 0);

        int descendingAreaValue = 1;

        Shapes firstAreaShape = getShapeWithConformingAreaValue(shapes, descendingAreaValue);

        System.out.println("Фигура с максимальной площадью имеет следующие геометрические характеристики: ");
        System.out.println("Ширина: " + firstAreaShape.getWidth());
        System.out.println("Высота: " + firstAreaShape.getHeight());
        System.out.println("Периметр: " + firstAreaShape.getPerimeter());
        System.out.println("Площадь: " + firstAreaShape.getArea());

        int descendingPerimeterValue = 2;

        Shapes secondPerimeterShape = getShapeWithConformingPerimeterValue(shapes, descendingPerimeterValue);

        System.out.println("Фигура со второй по величине периметром имеет следующие геометрические характеристики: ");
        System.out.println("Ширина: " + secondPerimeterShape.getWidth());
        System.out.println("Высота: " + secondPerimeterShape.getHeight());
        System.out.println("Периметр: " + secondPerimeterShape.getPerimeter());
        System.out.println("Площадь: " + secondPerimeterShape.getArea());
    }
}