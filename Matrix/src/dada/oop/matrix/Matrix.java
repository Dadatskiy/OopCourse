package dada.oop.matrix;

import dada.oop.vector.Vector;

public class Matrix {
    private Vector[] vectors;

    public Matrix(int rowsCount, int columnsCount) {
        if (rowsCount < 1) {
            throw new IllegalArgumentException("Неверно задано количество строк: (" + rowsCount
                    + "). Количество строк матрицы не может быть меньше единицы!");
        }

        if (columnsCount < 1) {
            throw new IllegalArgumentException("Неверно задано количество столбцов: (" + columnsCount
                    + "). Количество столбцов матрицы не может быть меньше единицы!");
        }

        vectors = arrayToVectors(new double[rowsCount][columnsCount]);
    }

    public Matrix(Matrix matrix) {
        int rowsCount = matrix.getRowsCount();
        vectors = new Vector[rowsCount];

        for (int i = 0; i < rowsCount; i++) {
            vectors[i] = new Vector(matrix.getRowVector(i));
        }
    }

    public Matrix(double[][] array) {
        if (array == null) {
            throw new NullPointerException("Передан массив со значением null");
        }

        if (array.length < 1) {
            throw new IllegalArgumentException("Неверно задано количество строк: (" + array.length
                    + "). Количество строк матрицы не может быть меньше единицы!");
        }

        if (array[0].length < 1) {
            throw new IllegalArgumentException("Неверно задано количество столбцов: (" + array[0].length
                    + "). Количество столбцов матрицы не может быть меньше единицы!");
        }

        vectors = arrayToVectors(array);
    }

    public Matrix(Vector[] vectors) {
        int rowsCount = vectors.length;
        int columnsCount = 0;

        for (Vector vector : vectors) {
            columnsCount = Math.max(columnsCount, vector.getSize());
        }

        this.vectors = arrayToVectors(new double[rowsCount][columnsCount]);

        for (int i = 0; i < rowsCount; i++) {
            for (int j = 0; j < vectors[i].getSize(); j++) {
                this.vectors[i].setComponent(j, vectors[i].getComponent(j));
            }
        }
    }

    private double[][] vectorsToArray() {
        int rowsCount = getRowsCount();
        int columnsCount = getColumnsCount();
        double[][] matrix = new double[rowsCount][columnsCount];

        for (int i = 0; i < rowsCount; i++) {
            for (int j = 0; j < columnsCount; j++) {
                matrix[i][j] = vectors[i].getComponent(j);
            }
        }

        return matrix;
    }

    private static Vector[] arrayToVectors(double[][] matrix) {
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
            throw new IllegalArgumentException("Размерность переданного вектора: (" + vector.getSize()
                    + ") должна совпадать с размерностью заменяемого: (" + getColumnsCount() + ")");
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
        int newRowsCount = getColumnsCount();
        int newColumnsCount = getRowsCount();
        Matrix transposedMatrix = new Matrix(newRowsCount, newColumnsCount);

        for (int i = 0; i < newRowsCount; i++) {
            transposedMatrix.setRowVector(i, getColumnVector(i));
        }

        return transposedMatrix;
    }

    public Matrix multiplyByScalar(double scalar) {
        for (Vector vector : vectors) {
            for (int j = 0; j < getColumnsCount(); j++) {
                vector.setComponent(j, vector.getComponent(j) * scalar);
            }
        }

        return this;
    }

    public Matrix add(Matrix matrix) {
        if (getRowsCount() != matrix.getRowsCount() || getColumnsCount() != matrix.getColumnsCount()) {
            throw new IllegalArgumentException("Сложение матриц возможно только в том случае, если они имеют одинаковые размеры");
        }

        int rowsCount = getRowsCount();
        int columnsCount = getColumnsCount();

        for (int i = 0; i < rowsCount; i++) {
            for (int j = 0; j < columnsCount; j++) {
                vectors[i].setComponent(j, vectors[i].getComponent(j) + matrix.getRowVector(i).getComponent(j));
            }
        }

        return this;
    }

    public Matrix subtract(Matrix matrix) {
        if (getRowsCount() != matrix.getRowsCount() || getColumnsCount() != matrix.getColumnsCount()) {
            throw new IllegalArgumentException("Вычитание матриц возможно только в том случае, если они имеют одинаковые размеры");
        }

        int rowsCount = getRowsCount();
        int columnsCount = getColumnsCount();

        for (int i = 0; i < rowsCount; i++) {
            for (int j = 0; j < columnsCount; j++) {
                vectors[i].setComponent(j, vectors[i].getComponent(j) - matrix.getRowVector(i).getComponent(j));
            }
        }

        return this;
    }

    public Matrix multiplyByVector(Vector vector) {
        if (getColumnsCount() != vector.getSize()) {
            throw new IllegalArgumentException("Умножение матрицы на вектор возможно только в том случае, " +
                    "если число столбцов матрицы равно числу строк вектора");
        }

        int rowsCount = getRowsCount();
        double[][] product = new double[rowsCount][1];

        for (int i = 0; i < rowsCount; i++) {
            product[i][0] = Vector.getScalarProduct(getRowVector(i), vector);
        }

        return new Matrix(arrayToVectors(product));
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("{ ");

        for (int i = 0; i < vectors.length - 1; i++) {
            stringBuilder.append((vectors[i])).append(", ");
        }

        stringBuilder.append(vectors[vectors.length - 1]).append(" }");
        return stringBuilder.toString();
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
        if (getRowsCount() != getColumnsCount()) {
            throw new IllegalArgumentException("У матрицы размерами " + getRowsCount() + "x" + getColumnsCount()
                    + "невозможно вычислить определитель. Вычислить определитель можно только у квадратной матрицы");
        }

        return getDeterminant(vectorsToArray());
    }

    public static Matrix getSum(Matrix matrix1, Matrix matrix2) {
        if (matrix1.getRowsCount() != matrix2.getRowsCount() || matrix1.getColumnsCount() != matrix2.getColumnsCount()) {
            throw new IllegalArgumentException("Складывание матриц возможно только в том случае, если они имеют одинаковые размеры");
        }

        Matrix matrix1Copy = new Matrix(matrix1);
        return new Matrix(matrix1Copy.add(matrix2));
    }

    public static Matrix getDifference(Matrix matrix1, Matrix matrix2) {
        if (matrix1.getRowsCount() != matrix2.getRowsCount() || matrix1.getColumnsCount() != matrix2.getColumnsCount()) {
            throw new IllegalArgumentException("Вычитание матриц возможно только в том случае, если они имеют одинаковые размеры");
        }

        Matrix matrix1Copy = new Matrix(matrix1);
        return new Matrix(matrix1Copy.subtract(matrix2));
    }

    public static Matrix getProduct(Matrix matrix1, Matrix matrix2) {
        if (matrix1.getRowsCount() != matrix2.getColumnsCount() || matrix1.getColumnsCount() != matrix2.getRowsCount()) {
            throw new IllegalArgumentException("Перемножение матриц возможно только в том случае, " +
                    "если число столбцов одной матрицы равно числу строк другой");
        }

        int newRowsCount = matrix1.getRowsCount();
        int newColumnsCount = matrix2.getColumnsCount();

        double[][] product = new double[newRowsCount][newColumnsCount];

        for (int i = 0; i < newRowsCount; i++) {
            for (int j = 0; j < newColumnsCount; j++) {
                product[i][j] = Vector.getScalarProduct(matrix1.getRowVector(i), matrix2.getColumnVector(j));
            }
        }

        return new Matrix(arrayToVectors(product));
    }
}