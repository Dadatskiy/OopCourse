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

        for (int i = 0; i <= this.n - 1; i++) {
            this.components[i] = 0;
        }
    }

    public Vector(Vector vector) {
        this.n = vector.getSize();
        this.components = vector.components;
    }

    public Vector(double[] components) {
        this.n = components.length;
        this.components = components;
    }

    public Vector(int n, double[] components) {
        this.n = n;
        this.components = components;
    }

    public int getSize() {
        return n;
    }
/*
    @Override
    public String toString() {
        return Arrays.toString(components);
    }*/
}
