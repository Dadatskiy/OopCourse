package dada.oop.matrix;

import dada.oop.vector.Vector;

import java.util.Arrays;

public class Matrix {
    private Vector[] vectors;

    public Matrix(int m, int n) {
        if (m < 1) {
            throw new IllegalArgumentException("Заданное количество строк: " + m + " не корректно! " +
                    "Количество строк в матрице не может быть меньше двух");
        }

        if (n < 1) {
            throw new IllegalArgumentException("Заданное количество столбцов: " + n + " не корректно! " +
                    "Количество столбцов в матрице не может быть меньше двух");
        }

        vectors = arrayToVectors(new double[m][n]);
    }

    public Matrix(Matrix matrix) {
        vectors = new Vector[matrix.getRowsCount()];

        for (int i = 0; i < matrix.getRowsCount(); i++) {
            vectors[i] = new Vector(matrix.getRowVector(i));
        }
    }

    public Matrix(double[][] array) {
        if (array == null) {
            throw new NullPointerException("Передан массив со значением null");
        }

        if (array.length < 1 || array[0].length < 1) {
            throw new IllegalArgumentException("Невозможно создать матрицу из переданного двумерного массива с размерами: "
                    + array.length + "x" + array[0].length + ". Минимальный допустимый размер: 1х1");
        }

        vectors = arrayToVectors(array);
    }

    public Matrix(Vector[] vectors) {
        int maxSize = 0;

        for (Vector vector : vectors) {
            maxSize = Math.max(maxSize, vector.getSize());
        }

        this.vectors = arrayToVectors(new double[vectors.length][maxSize]);

        for (int i = 0; i < vectors.length; i++) {
            for (int j = 0; j < vectors[0].getSize(); j++) {
                this.vectors[i].setComponent(j, vectors[i].getComponent(j));
            }
        }
    }

    private double[][] vectorsToArray() {
        double[][] matrix = new double[getRowsCount()][getColumnsCount()];

        for (int i = 0; i < getRowsCount(); i++) {
            for (int j = 0; j < getColumnsCount(); j++) {
                matrix[i][j] = vectors[i].getComponent(j);
            }
        }

        return matrix;
    }

    private Vector[] arrayToVectors(double[][] matrix) {
        Vector[] vectors = new Vector[matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            vectors[i] = new Vector(matrix[i]);
        }

        return vectors;
    }

    public int getRowsCount() {
        return vectors.length;
    }

    public int getColumnsCount() {
        return vectors[0].getSize();
    }

    public Vector getRowVector(int rowIndex) {
        return vectors[rowIndex];
    }

    public void setRowVector(int rowNumber, Vector vector) {
        if (rowNumber < 0) {
            throw new IllegalArgumentException("Передан некорректный индекс: " + rowNumber
                    + ". Индекс должен быть в диапазоне от 0 до " + getRowsCount());
        }

        if (vector.getSize() != getColumnsCount()) {
            throw new IllegalArgumentException("Размерность переданного вектора: " + vector.getSize()
                    + " должна совпадать с размерностью заменяемого: getColumnsCount()");
        }

        vectors[rowNumber] = vector;
    }

    public Vector getColumnVector(int columnIndex) {
        Vector columnVector = new Vector(vectors.length);

        for (int i = 0; i < vectors.length; i++) {
            columnVector.setComponent(i, getRowVector(i).getComponent(columnIndex));
        }

        return columnVector;
    }

    public Matrix transpose() {
        Matrix transposedMatrix = new Matrix(getRowsCount(), getColumnsCount());

        for (int i = 0; i < vectors.length; i++) {
            transposedMatrix.setRowVector(i, getColumnVector(i));
            vectors[i] = transposedMatrix.getRowVector(i);
        }

        return this;
    }

    public Matrix multiByScalar(double scalar) {
        for (Vector vector : vectors) {
            for (int j = 0; j < getColumnsCount(); j++) {
                vector.setComponent(j, vector.getComponent(j) * scalar);
            }
        }

        return this;
    }

    public Matrix addMatrix(Matrix matrix) {
        if (getRowsCount() != matrix.getRowsCount() || getColumnsCount() != matrix.getColumnsCount()) {
            throw new IllegalArgumentException("Складывание матриц возможно только в том случае, если они имеют одинаковые размеры");
        }

        for (int i = 0; i < getRowsCount(); i++) {
            for (int j = 0; j < getColumnsCount(); j++) {
                vectors[i].setComponent(j, vectors[i].getComponent(j) + matrix.getRowVector(i).getComponent(j));
            }
        }

        return this;
    }

    public Matrix subtractMatrix(Matrix matrix) {
        if (getRowsCount() != matrix.getRowsCount() || getColumnsCount() != matrix.getColumnsCount()) {
            throw new IllegalArgumentException("Вычитание матриц возможно только в том случае, если они имеют одинаковые размеры");
        }

        for (int i = 0; i < getRowsCount(); i++) {
            for (int j = 0; j < getColumnsCount(); j++) {
                vectors[i].setComponent(j, vectors[i].getComponent(j) - matrix.getRowVector(i).getComponent(j));
            }
        }

        return this;
    }

    private double[] getArrayFromDouble(double component) {
        double[] doubles = new double[1];
        doubles[0] = component;
        return doubles;
    }

    public Matrix multiplyByVector(Vector vector) {
        // TODO: 07.09.2022 реализовать проверку входных данных
        Matrix product = new Matrix(getRowsCount(), 1);

        for (int i = 0; i < getRowsCount(); i++) {
            double[] newComponents = getArrayFromDouble(Vector.getScalarProduct(vectors[i], vector));
            product.setRowVector(i, new Vector(newComponents));
        }

        return product;
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

        for (int i = 0; i < vectors.length - 1; i++) {
            matrixString.append((vectors[i])).append("\n");
        }

        matrixString.append(vectors[vectors.length - 1]);
        return String.valueOf(matrixString);
    }

    private static double[][] getMinor(double[][] array, int r) {
        double[][] minor = new double[array.length - 1][array[0].length - 1];

        for (int i = 0, k = 0; i < minor.length; i++, k++) {
            for (int j = 0, l = 0; j < minor[0].length; j++, l++) {
                if (k == r) {
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

    private static double getDeterminant(double[][] array) {
        // TODO: 07.09.2022 реализовать проверку входных данных**
        double determinant = 0;

        if (array.length == 2) {
            determinant = array[0][0] * array[1][1] - array[0][1] * array[1][0];
            return determinant;
        }

        for (int i = 0; i < array.length; i++) {
            if (i % 2 == 0) {
                determinant += getDeterminant(getMinor(array, i)) * array[i][0];
            } else
                determinant -= getDeterminant(getMinor(array, i)) * array[i][0];
        }

        return determinant;
    }

    public double getDeterminant() {
        return getDeterminant(vectorsToArray());
    }

    public static Matrix getSum(Matrix matrix1, Matrix matrix2) {
        if (matrix1.getRowsCount() != matrix2.getRowsCount() || matrix1.getColumnsCount() != matrix2.getColumnsCount()) {
            throw new IllegalArgumentException("Складывание матриц возможно только в том случае, если они имеют одинаковые размеры");
        }

        Matrix matrix1Copy = new Matrix(matrix1);
        Matrix matrix2Copy = new Matrix(matrix2);
        return new Matrix(matrix1Copy.addMatrix(matrix2Copy));
    }

    public static Matrix getDiff(Matrix matrix1, Matrix matrix2) {
        if (matrix1.getRowsCount() != matrix2.getRowsCount() || matrix1.getColumnsCount() != matrix2.getColumnsCount()) {
            throw new IllegalArgumentException("Вычитание матриц возможно только в том случае, если они имеют одинаковые размеры");
        }

        Matrix matrix1Copy = new Matrix(matrix1);
        Matrix matrix2Copy = new Matrix(matrix2);
        return new Matrix(matrix1Copy.subtractMatrix(matrix2Copy));
    }

   /* public static Matrix getProduct(Matrix matrix1, Matrix matrix2) {
        if (matrix1.getRowsCount() != matrix2.getColumnsCount() || matrix1.getColumnsCount() != matrix2.getRowsCount()) {
            throw new IllegalArgumentException("Перемножение матриц возможно только в том случае, " +
                    "если число столбцов одной матрицы равно числу строк другой");
        }

        for (int i = 0; i < matrix1.getColumnsCount(); i++) {
            for (int j = 0; j < matrix2.getRowsCount(); j++) {

            }
        }
    }*/
}