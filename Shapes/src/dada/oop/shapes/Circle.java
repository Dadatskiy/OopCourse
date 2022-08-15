package dada.oop.shapes;

public class Circle implements Shapes {
    private final double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double getWidth() {
        return 2 * radius;
    }

    @Override
    public double getHeight() {
        return 2 * radius;
    }

    @Override
    public double getArea() {
        return Math.PI * Math.pow(radius, 2);
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public String toString() {
        return "Тип фигуры: Круг" + "\n" + "Ширина = " + 2 * radius + "\n" + "Высота = " + 2 * radius + "\n" +
                "Периметр = " + getPerimeter() + "\n" + "Площадь = " + getArea();
    }

    @Override
    public int hashCode() {
        final int prime = 37;
        int hash = 1;
        hash = prime * hash + Double.hashCode(radius);
        return hash;
    }

    @Override
    public boolean equals(Object circle) {
        if (circle == this) {
            return true;
        }

        if (circle == null || circle.getClass() != getClass()) {
            return false;
        }

        Circle circle1 = (Circle) circle;
        return radius == circle1.radius;
    }
}