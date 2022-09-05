package dada.oop.comparators;

import dada.oop.shapes.Shape;

import java.util.Comparator;

public class shapePerimeterComparator implements Comparator<Shape> {
    @Override
    public int compare(Shape shape1, Shape shape2) {
        return Double.compare(shape1.getPerimeter(), shape2.getPerimeter());

    }
}