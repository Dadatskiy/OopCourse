package dada.oop.matrix;

import dada.oop.vector.Vector;

public class Matrix {
    private int n; // height
    private int m; // width
    private double[][] array;
    private Vector[] vectors;

    public Matrix(int n, int m) {
        if (n < 1 || m < 1) {
            throw new IllegalArgumentException("Матрица размерами " + n + " х " + m
                    + " не может существовать. " + "Количество столбцов или строк в матрице не может быть меньше одного");
        }

        this.n = n;
        this.m = m;
        this.array = new double[n][m];
        this.vectors = arrayToVectors();
    }

    public Matrix(Matrix matrix) {
        this.n = matrix.n;
        this.m = matrix.m;
        this.array = matrix.array;
        this.vectors = matrix.vectors;
    }

    public Matrix(double[][] array) {
        this.n = array.length;
        this.m = array[0].length;
        this.array = array;
        this.vectors = arrayToVectors();
    }

    public Matrix(Vector[] vectors) {
        this.vectors = vectors;
    }

    private Vector[] arrayToVectors() {
        Vector[] vectorsFromArray = new Vector[array.length];

        for (int i = 0; i <= array.length - 1; i++) {
            vectorsFromArray[i] = fromRawToVector(i);
        }

        return vectorsFromArray;
    }

    private Vector fromRawToVector(int rowNumber) {
        return new Vector(array[rowNumber]);
    }

    @Override
    public String toString() {
        StringBuilder matrixString = new StringBuilder("{ ");
/*
        for (int i = 0; i < array.length - 1; i++) {
            matrixString.append((fromRawToVector(i))).append(", ");
        }

        matrixString.append(fromRawToVector(array.length - 1)).append("}");
*/
        for (int i = 0; i < array.length - 1; i++) {
            matrixString.append((vectors[i])).append(", ");
        }

        matrixString.append(vectors[array.length - 1]).append(" }");

        return String.valueOf(matrixString);
    }
}