package dada.oop.shapes;

public class Triangle implements Shapes {
    private final double x1;
    private final double y1;
    private final double x2;
    private final double y2;
    private final double x3;
    private final double y3;

    public Triangle(double x1, double y1, double x2, double y2, double x3, double y3) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.x3 = x3;
        this.y3 = y3;

        double epsilon = 1e-10;

        if (Math.abs((y3 - y1) * (x2 - x1) - (x3 - x1) * (y2 - y1)) < epsilon) {
            throw new RuntimeException("По заданным координатам не может существовать треугольник!");
        }
    }

    @Override
    public double getWidth() {
        return Math.max(Math.max(x1, x2), x3) - Math.min(Math.min(x1, x2), x3);
    }

    @Override
    public double getHeight() {
        return Math.max(Math.max(y1, y2), y3) - Math.min(Math.min(y1, y2), y3);
    }

    private double getSideSize1() {
        return Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
    }

    private double getSideSize2() {
        return Math.sqrt(Math.pow((x3 - x2), 2) + Math.pow((y3 - y2), 2));
    }

    private double getSideSize3() {
        return Math.sqrt(Math.pow((x3 - x1), 2) + Math.pow((y3 - y1), 2));
    }

    @Override
    public double getPerimeter() {
        return getSideSize1() + getSideSize2() + getSideSize3();
    }

    @Override
    public double getArea() {
        double semiPerimeter = getPerimeter() / 2;
        return Math.sqrt(semiPerimeter *
                (semiPerimeter - getSideSize1()) * (semiPerimeter - getSideSize2()) * (semiPerimeter - getSideSize3()));
    }
}