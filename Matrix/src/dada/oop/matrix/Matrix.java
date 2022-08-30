package dada.oop.matrix;

import dada.oop.vector.Vector;

public class Matrix {
    private int m; //  rowsCount
    private int n; // columnsCount
    private double[][] array;
    private Vector[] vectors;

    public Matrix(int m, int n) {
        if (m < 1 || n < 1) {
            throw new IllegalArgumentException("Матрица размерами " + m + " х " + n
                    + " не может существовать. " + "Количество строк или столбцов в матрице не может быть меньше одного");
        }

        this.m = m;
        this.n = n;
        this.array = new double[m][n];
        this.vectors = arrayToVectors();
    }

    public Matrix(Matrix matrix) {
        this.m = matrix.m;
        this.n = matrix.n;
        this.array = matrix.array;
        this.vectors = matrix.vectors;
    }

    public Matrix(double[][] array) {
        this.m = array.length;
        this.n = array[0].length;
        this.array = array;
        this.vectors = arrayToVectors();
    }

    public Matrix(Vector[] vectors) {
        this.m = vectors.length;

        int maxLength = 0;

        for (int i = 0; i < m; i++) {
            maxLength = Math.max(maxLength, vectors[i].getSize());
        }

        this.n = maxLength;

        for (int i = 0; i < m; i++) {
            vectors[i].toCompleteVector(n);
        }

        this.vectors = vectors;
        this.array = new double[m][n];
        vectorsToArray();
    }

    private void vectorsToArray() {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                array[i][j] = vectors[i].getComponent(j);
            }
        }
    }

    private Vector[] arrayToVectors() {
        Vector[] vectorsFromArray = new Vector[m];

        for (int i = 0; i < m; i++) {
            vectorsFromArray[i] = fromRawToVector(i);
        }

        return vectorsFromArray;
    }

    private Vector fromRawToVector(int rowNumber) {
        return new Vector(array[rowNumber]);
    }

    public double[][] getArray() {
        return array;
    }

    public int getRowsCount() {
        return m;
    }

    public int getColumnsCount() {
        return n;
    }

    public Vector getRowVector(int rowIndex) {
        return vectors[rowIndex];
    }

    public void setRowVector(int rowNumber, Vector vector) {
        vectors[rowNumber] = vector;
        array[rowNumber] = vector.getComponents();
    }

    public Vector getColumnVector(int columnIndex) {
        Vector vector = new Vector(m);

        for (int i = 0; i < m; i++) {
            vector.setComponent(i, array[i][columnIndex]);
        }

        return vector;
    }

    public Matrix transpose() {
        Matrix matrixTemp = new Matrix(n, m);

        for (int i = 0; i < n; i++) {
            matrixTemp.setRowVector(i, this.getColumnVector(i));
            vectors[i] = matrixTemp.getRowVector(i);
        }

        int temp = m;
        m = n;
        n = temp;

        array = new double[m][n];
        vectorsToArray();

        return this;
    }

    public Matrix multiByScalar(double scalar) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                array[i][j] = array[i][j] * scalar;
            }
        }

        vectors = arrayToVectors();

        return this;
    }

    public Matrix addMatrix(Matrix matrix) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                array[i][j] = array[i][j] + matrix.getRowVector(i).getComponent(j);
            }
        }

        vectors = arrayToVectors();

        return this;
    }

    public Matrix subtractMatrix(Matrix matrix) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                array[i][j] = array[i][j] - matrix.getRowVector(i).getComponent(j);
            }
        }

        vectors = arrayToVectors();

        return this;
    }

    public Matrix multiByMatrix(Matrix matrix) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                array[i][j] = array[i][j] * matrix.getRowVector(i).getComponent(j);
            }
        }

        vectors = arrayToVectors();

        return this;
    }

    public static Matrix getSum(Matrix matrix1, Matrix matrix2) {
        return matrix1.addMatrix(matrix2);
    }

    public static Matrix getDiff(Matrix matrix1, Matrix matrix2) {
        return matrix1.subtractMatrix(matrix2);
    }

    public static Matrix getMultiply(Matrix matrix1, Matrix matrix2) {
        return matrix1.multiByMatrix(matrix2);
    }

    /*
        @Override
        public String toString() {
            StringBuilder matrixString = new StringBuilder("{ ");

            for (int i = 0; i < n - 1; i++) {
                matrixString.append((vectors[i])).append(", ");
            }

            matrixString.append(vectors[n - 1]).append(" }");
            return String.valueOf(matrixString);
        }
    */
    @Override
    public String toString() {
        StringBuilder matrixString = new StringBuilder();

        for (int i = 0; i < m - 1; i++) {
            matrixString.append((vectors[i])).append("\n");
        }

        matrixString.append(vectors[m - 1]);
        return String.valueOf(matrixString);
    }

    public double[][] getMinor(double[][] array) {
        double[][] minor = new double[array.length - 1][array[0].length - 1];

        for (int i = 0, k = 0; i < minor.length; i++, k++) {
            for (int j = 0, l = 0; j < minor[0].length; j++, l++) {
                if (k == i) {
                    k++;
                }

                if (l == j) {
                    l++;
                }

                minor[i][j] = array[k][l];
            }
        }

        return minor;
    }

    public double getSub(double [][] array) {
        double bag = 0;

        if (array.length == 2) {
            bag = array[0][0] * array[1][1] - array[0][1] * array[1][0];
        }

        for (int i = 0; i < array.length; i++) {
            if (i % 2 == 0) {
                bag += getSub(getMinor(array));
            } else
                bag -= getSub(getMinor(array));
        }

        return bag;
    }
}