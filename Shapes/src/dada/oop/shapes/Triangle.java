package dada.oop.shapes;

public class Triangle implements Shapes {
    private double x1;
    private double y1;
    private double x2;
    private double y2;
    private double x3;
    private double y3;

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

    public double getX1() {
        return x1;
    }

    public void setX1(double x1) {
        this.x1 = x1;
    }

    public double getY1() {
        return y1;
    }

    public void setY1(double y1) {
        this.y1 = y1;
    }

    public double getX2() {
        return x2;
    }

    public void setX2(double x2) {
        this.x2 = x2;
    }

    public double getY2() {
        return y2;
    }

    public void setY2(double y2) {
        this.y2 = y2;
    }

    public double getX3() {
        return x3;
    }

    public void setX3(double x3) {
        this.x3 = x3;
    }

    public double getY3() {
        return y3;
    }

    public void setY3(double y3) {
        this.y3 = y3;
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

    @Override
    public String toString() {
        return "Тип фигуры: Треугольник" + "\n" + "Ширина = " + getWidth() + "\n" + "Высота = " + getHeight() + "\n" +
                "Периметр = " + getPerimeter() + "\n" + "Площадь = " + getArea();
    }

    @Override
    public int hashCode() {
        final int prime = 37;
        int hash = 1;
        hash = prime * hash + Double.hashCode(x1);
        hash = prime * hash + Double.hashCode(y1);
        hash = prime * hash + Double.hashCode(x2);
        hash = prime * hash + Double.hashCode(y2);
        hash = prime * hash + Double.hashCode(x3);
        hash = prime * hash + Double.hashCode(y3);
        return hash;
    }

    @Override
    public boolean equals(Object triangle) {
        if (triangle == this) {
            return true;
        }

        if (triangle == null || triangle.getClass() != getClass()) {
            return false;
        }

        Triangle triangle1 = (Triangle) triangle;
        return x1 == triangle1.x1 && y1 == triangle1.y1 &&
                x2 == triangle1.x2 && y2 == triangle1.y2 && x3 == triangle1.x3 && y3 == triangle1.y3;
    }
}