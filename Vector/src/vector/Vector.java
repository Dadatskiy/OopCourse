package vector;

import java.util.Arrays;

public class Vector {
    private int n;

    private double[] components;

    public Vector(int n) {
        this.n = n;

        if (n < 0) {
            throw new IllegalArgumentException();
        }

        components = new double[n];
    }

    public Vector(Vector vector) {
        this.n = vector.n;
        this.components = vector.components;
    }

    public Vector(double[] components) {
        this.n = components.length;
        this.components = components;
    }

    public Vector(int n, double[] transferredComponents) {
        this.n = n;

        if (n < transferredComponents.length) {
            throw new IllegalArgumentException();
        } else if (n == transferredComponents.length) {
            this.components = transferredComponents;
        } else {
            this.components = new double[n];

            System.arraycopy(transferredComponents, 0, this.components, 0, transferredComponents.length);
        }
    }

    public void toCompleteVector(Vector transferredVector) {
        double[] tempComponents = components;

        this.components = new double[transferredVector.getSize()];

        System.arraycopy(tempComponents, 0, this.components, 0, n);
    }

    public Vector addVector(Vector vector) {
        if (n < vector.getSize()) {
            toCompleteVector(vector);
        }

        for (int i = 0; i < Math.max(vector.getSize(), n); i++) {
            this.components[i] = this.components[i] + vector.components[i];
        }

        return new Vector(components);
    }

    public Vector subtractVector(Vector vector) {
        if (n > vector.getSize()) {
            for (int i = 0; i < vector.getSize(); i++) {
                this.components[i] = this.components[i] - vector.components[i];
            }
        }

        if (n <= vector.getSize()) {
            toCompleteVector(vector);
            for (int i = 0; i < n; i++) {
                this.components[i] = this.components[i] - vector.components[i];
            }
        }

        return new Vector(components);
    }

    public Vector multiplyByScalar(double scalar) {
        for (int i = 0; i < n; i++) {
            this.components[i] = this.components[i] * scalar;
        }

        return new Vector(components);
    }

    public Vector revertVector() {
        for (int i = 0; i < n; i++) {
            this.components[i] = -this.components[i];
        }

        return new Vector(components);
    }

    public double getVectorLength() {
        double squaredComponents = 0;

        for (double component : components) {
            squaredComponents = Math.pow(component, 2) + squaredComponents;
        }

        return Math.sqrt(squaredComponents);
    }

    public int getSize() {
        return n;
    }

    public double getComponent(int index) {
        return components[index];
    }

    public void setComponent(int index, double component) {
        this.components[index] = component;
    }

    @Override
    public String toString() {
        if (components.length == 0) {
            return "{}";
        }

        if (components.length == 1) {
            return "{" + components[0] + "}";
        }

        StringBuilder componentsString = new StringBuilder("{" + components[0] + ", ");

        for (int i = 1; i < components.length - 1; i++) {
            componentsString.append(components[i]).append(", ");
        }

        componentsString.append(components[components.length - 1]).append("}");
        return String.valueOf(componentsString);
    }

    @Override
    public boolean equals(Object vector) {
        if (vector == this) {
            return true;
        }

        if (vector == null || getClass() != vector.getClass()) {
            return false;
        }

        Vector vector1 = (Vector) vector;
        return n == vector1.n && Arrays.equals(components, vector1.components);
    }

    @Override
    public int hashCode() {
        final int prime = 37;
        int hash = 1;
        hash = prime * hash + Integer.hashCode(n);
        hash = prime * hash + Arrays.hashCode(components);
        return hash;
    }

    public static Vector getVectorSum(Vector vector1, Vector vector2) {
        return new Vector(vector1.addVector(vector2));
    }

    public static Vector getVectorDiff(Vector vector1, Vector vector2) {
        return new Vector(vector1.subtractVector(vector2));
    }

    private static double scalarMulti;

    public static double getScalarMulti(Vector vector1, Vector vector2) {
        for (int i = 0; i < Math.min(vector1.getSize(), vector2.getSize()); i++) {
            scalarMulti = scalarMulti + vector1.getComponent(i) * vector2.getComponent(i);
        }

        return scalarMulti;
    }
}