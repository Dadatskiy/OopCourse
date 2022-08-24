package dada.oop.shapes;

import java.util.Comparator;

public class SortByPerimeter implements Comparator<Shape> {
    @Override
    public int compare(Shape shape1, Shape shape2) {
        if (shape1.getPerimeter() < shape2.getPerimeter()) {
            return -1;
        }

        if (shape1.getPerimeter() == shape2.getPerimeter()) {
            return 0;
        }

        return 1;
    }
}