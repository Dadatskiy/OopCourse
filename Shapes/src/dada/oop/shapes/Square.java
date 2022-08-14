package dada.oop.shapes;

public class Square implements Shapes {
    private final double sideSize;

    public Square (double sideSize) {
        this.sideSize = sideSize;
    }
    @Override
    public double getWidth() {
        return sideSize;
    }

    @Override
    public double getHeight() {
        return sideSize;
    }

    @Override
    public double getArea() {
        return sideSize * sideSize;
    }

    @Override
    public double getPerimeter() {
        return 4 * sideSize;
    }
}