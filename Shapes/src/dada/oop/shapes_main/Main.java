package dada.oop.shapes_main;

import dada.oop.shapes.*;
import dada.oop.shapes.Rectangle;

import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static Shape getShapeWithConformingAreaValue(Shape[] shapes, int whatAreaValue) {
        Arrays.sort(shapes, Comparator.comparing(Shape::getArea));
        return shapes[shapes.length - whatAreaValue];
    }

    public static Shape getShapeWithConformingPerimeterValue(Shape[] shapes, int whatPerimeterArea) {
        Arrays.sort(shapes, Comparator.comparing(Shape::getPerimeter));
        return shapes[shapes.length - whatPerimeterArea];
    }

    public static void main(String[] args) {

        Triangle triangle1 = new Triangle(-6, 11, 4, 7, 10, 13);

        Triangle triangle2 = new Triangle(12, 10, -8, 19, 1, 33);

        Square square1 = new Square(32);

        Rectangle rectangle1 = new Rectangle(40, 51);

        Rectangle rectangle2 = new Rectangle(40, 51);

        Circle circle1 = new Circle(35);

        Shape[] shapes = {triangle1, triangle2, square1, new Square(32), rectangle1, rectangle2, circle1, new Circle(35)};

        int whatAreaValue = 1;

        Shape firstAreaShape = getShapeWithConformingAreaValue(shapes, whatAreaValue);

        System.out.println("Фигура с максимальной площадью имеет следующие характеристики: ");
        System.out.println(firstAreaShape);

        int whatPerimeterArea = 2;

        Shape secondPerimeterShape = getShapeWithConformingPerimeterValue(shapes, whatPerimeterArea);

        System.out.println("Фигура со вторым по величине периметром имеет следующие характеристики: ");
        System.out.println(secondPerimeterShape);

        System.out.println(square1.equals(shapes[3]));
    }
}