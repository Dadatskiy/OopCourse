package dada.oop.vector;

import java.util.Arrays;

public class Vector {

    private double[] components;

    public Vector(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("Некорректная размерность вектора: " + size + ", должна быть больше нуля");
        }

        components = new double[size];
    }

    public Vector(Vector vector) {
        components = Arrays.copyOf(vector.components, vector.components.length);
    }

    public Vector(double[] components) {
        if (components.length <= 0) {
            throw new IllegalArgumentException("В качестве компонентов передан пустой массив, размерность вектора должна быть больше нуля");
        }

        this.components = Arrays.copyOf(components, components.length);
    }

    public Vector(int size, double[] components) {
        if (size <= 0) {
            throw new IllegalArgumentException("Некорректная размерность вектора: " + size + ", должна быть больше нуля");
        }

        this.components = Arrays.copyOf(components, size);
    }

    public int getSize() {
        return components.length;
    }

    public double getComponent(int index) {
        return components[index];
    }

    public void setComponent(int index, double component) {
        components[index] = component;
    }

    private void increaseVectorSize(int necessarySize) {
        double[] originalComponents = components;
        components = new double[necessarySize];
        components = Arrays.copyOf(originalComponents, components.length);
    }

    public Vector add(Vector vector) {
        if (components.length < vector.components.length) {
            increaseVectorSize(vector.components.length);
        }

        for (int i = 0; i < vector.components.length; i++) {
            components[i] += vector.components[i];
        }

        return this;
    }

    public Vector subtract(Vector vector) {
        if (components.length < vector.components.length) {
            increaseVectorSize(vector.components.length);
        }

        for (int i = 0; i < vector.components.length; i++) {
            components[i] -= vector.components[i];
        }

        return this;
    }

    public Vector multiplyByScalar(double scalar) {
        for (int i = 0; i < components.length; i++) {
            components[i] *= scalar;
        }

        return this;
    }

    public Vector revert() {
        multiplyByScalar(-1);
        return this;
    }

    public double getLength() {
        double componentsSquaredSum = 0;

        for (double component : components) {
            componentsSquaredSum += component * component;
        }

        return Math.sqrt(componentsSquaredSum);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("{");

        for (int i = 0; i < components.length - 1; i++) {
            stringBuilder.append(components[i]).append(", ");
        }

        stringBuilder.append(components[components.length - 1]).append("}");
        return stringBuilder.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Vector vector = (Vector) o;
        return components.length == vector.components.length && Arrays.equals(components, vector.components);
    }

    @Override
    public int hashCode() {
        final int prime = 37;
        int hash = 1;
        hash = prime * hash + Arrays.hashCode(components);
        return hash;
    }

    public static Vector getSum(Vector vector1, Vector vector2) {
        Vector vector1Copy = new Vector(vector1);
        Vector vector2Copy = new Vector(vector2);
        return new Vector(vector1Copy.add(vector2Copy));
    }

    public static Vector getDifference(Vector vector1, Vector vector2) {
        Vector vector1Copy = new Vector(vector1);
        Vector vector2Copy = new Vector(vector2);
        return new Vector(vector1Copy.subtract(vector2Copy));
    }

    public static double getScalarProduct(Vector vector1, Vector vector2) {
        double scalarProduct = 0;
        int iterationsCount = Math.min(vector1.components.length, vector2.components.length) - 1;

        for (int i = 0; i <= iterationsCount; i++) {
            scalarProduct = scalarProduct + vector1.components[i] * vector2.components[i];
        }

        return scalarProduct;
    }
}