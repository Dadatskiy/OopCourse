package dada.oop.shapes_main;

import dada.oop.shapes_comparators.ShapeAreaComparator;
import dada.oop.shapes_comparators.ShapePerimeterComparator;
import dada.oop.shapes.*;
import dada.oop.shapes.Rectangle;

import java.util.Arrays;

public class Main {
    public static Shape getShapeWithConformingAreaNumber(Shape[] shapes, int indexFromEnd) {
        if (shapes == null) {
            throw new NullPointerException("shapes is null");
        }

        if (indexFromEnd <= 0 || indexFromEnd > shapes.length) {
            throw new ArrayIndexOutOfBoundsException("Передан недопустимый индекс: " + indexFromEnd + ". Индекс должен быть в пределах от 1 до " + shapes.length);
        }

        Arrays.sort(shapes, new ShapeAreaComparator());
        return shapes[shapes.length - indexFromEnd];
    }

    public static Shape getShapeWithConformingPerimeterNumber(Shape[] shapes, int indexFromEnd) {
        if (shapes == null) {
            throw new NullPointerException("shapes is null");
        }

        if (indexFromEnd <= 0 || indexFromEnd > shapes.length) {
            throw new ArrayIndexOutOfBoundsException("Передан недопустимый индекс: " + indexFromEnd + ". Индекс должен быть в пределах от 1 до " + shapes.length);
        }

        Arrays.sort(shapes, new ShapePerimeterComparator());
        return shapes[shapes.length - indexFromEnd];
    }

    public static void main(String[] args) {
        Triangle triangle1 = new Triangle(-6, 11, 4, 7, 10, 13);

        Triangle triangle2 = new Triangle(12, 10, -8, 19, 1, 33);

        Square square1 = new Square(32);

        Rectangle rectangle1 = new Rectangle(40, 51);

        Rectangle rectangle2 = new Rectangle(40, 51);

        Circle circle1 = new Circle(35);

        Shape[] shapes = {
                triangle1,
                triangle2,
                square1,
                new Square(32),
                rectangle1,
                rectangle2,
                circle1,
                new Circle(35)
        };

        int shapeAreaIndexFromEnd = 1;

        Shape firstAreaShape = getShapeWithConformingAreaNumber(shapes, shapeAreaIndexFromEnd);

        System.out.println("Фигура с максимальной площадью имеет следующие характеристики: ");
        System.out.println(firstAreaShape);

        int shapePerimeterIndexFromEnd = 2;

        Shape secondPerimeterShape = getShapeWithConformingPerimeterNumber(shapes, shapePerimeterIndexFromEnd);

        System.out.println("Фигура со вторым по величине периметром имеет следующие характеристики: ");
        System.out.println(secondPerimeterShape);

        System.out.println("Проверка на равенство объектов square1 и элемента массива объектов Shapes по индексу 3:");
        System.out.println("Результат: " + square1.equals(shapes[3]));
    }
}