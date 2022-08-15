package dada.oop.shapes;

public class Rectangle implements Shapes {
    private final double width;
    private final double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double getWidth() {
        return width;
    }

    @Override
    public double getHeight() {
        return height;
    }

    @Override
    public double getArea() {
        return width * height;
    }

    @Override
    public double getPerimeter() {
        return 2 * (width + height);
    }

    @Override
    public String toString() {
        return "Тип фигуры: Прямоугольник" + "\n" + "Ширина = " + width + "\n" + "Высота = " + height + "\n" +
                "Периметр = " + getPerimeter() + "\n" + "Площадь = " + getArea();
    }

    @Override
    public int hashCode() {
        final int prime = 37;
        int hash = 1;
        hash = prime * hash + Double.hashCode(width);
        hash = prime * hash + Double.hashCode(height);
        return hash;
    }

    @Override
    public boolean equals(Object rectangle) {
        if (rectangle == this) {
            return true;
        }

        if (rectangle == null || rectangle.getClass() != getClass()) {
            return false;
        }

        Rectangle rectangle1 = (Rectangle) rectangle;
        return width == rectangle1.width && height == rectangle1.height;
    }
}