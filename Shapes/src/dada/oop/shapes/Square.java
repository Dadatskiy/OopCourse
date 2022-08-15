package dada.oop.shapes;

public class Square implements Shapes {
    private final double sideSize;

    public Square(double sideSize) {
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

    @Override
    public String toString() {
        return "Тип фигуры: Круг" + "\n" + "Ширина = " + sideSize + "\n" + "Высота = " + sideSize + "\n" +
                "Периметр = " + getPerimeter() + "\n" + "Площадь = " + getArea();
    }

    @Override
    public int hashCode() {
        final int prime = 37;
        int hash = 1;
        hash = prime * hash + Double.hashCode(sideSize);
        return hash;
    }

    @Override
    public boolean equals(Object square) {
        if (square == this) {
            return true;
        }

        if (square == null || square.getClass() != getClass()) {
            return false;
        }

        Square square1 = (Square) square;
        return sideSize == square1.sideSize;
    }
}