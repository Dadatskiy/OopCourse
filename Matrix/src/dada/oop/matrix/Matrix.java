package dada.oop.matrix;

import dada.oop.vector.Vector;

public class Matrix {
    private Vector[] rows;

    public Matrix(int rowsCount, int columnsCount) {
        if (rowsCount == 0) {
            throw new IllegalArgumentException("Количество строк матрицы не может быть равно нулю!");
        }

        if (columnsCount == 0) {
            throw new IllegalArgumentException("Количество столбцов матрицы не может быть равно нулю!");
        }

        rows = new Vector[rowsCount];

        for (int i = 0; i < rowsCount; i++) {
            rows[i] = new Vector(columnsCount);
        }
    }

    public Matrix(Matrix matrix) {
        int rowsCount = matrix.rows.length;
        rows = new Vector[rowsCount];

        for (int i = 0; i < rowsCount; i++) {
            rows[i] = new Vector(matrix.rows[i]);
        }
    }

    public Matrix(double[][] array) {
        if (array == null) {
            throw new NullPointerException("Передан массив со значением null");
        }

        if (array.length == 0) {
            throw new IllegalArgumentException("Количество строк матрицы не может быть равно нулю!");
        }

        Vector[] vectors = new Vector[array.length];

        int vectorSize = 0;

        for (double[] row : array) {
            vectorSize = Math.max(vectorSize, row.length);
        }

        if (vectorSize == 0) {
            throw new IllegalArgumentException("Количество столбцов матрицы не может быть равно нулю!");
        }

        for (int i = 0; i < array.length; i++) {
            vectors[i] = new Vector(vectorSize, array[i]);
        }

        rows = vectors;
    }

    public Matrix(Vector[] vectors) {
        if (vectors.length == 0) {
            throw new IllegalArgumentException("Количество строк матрицы не может быть равно нулю!");
        }

        int rowsCount = vectors.length;
        int columnsCount = 0;

        for (Vector vector : vectors) {
            columnsCount = Math.max(columnsCount, vector.getSize());
        }

        rows = new Vector[rowsCount];

        for (int i = 0; i < rowsCount; i++) {
            rows[i] = new Vector(columnsCount);
            rows[i] = rows[i].add(vectors[i]);
        }
    }

    public int getRowsCount() {
        return rows.length;
    }

    public int getColumnsCount() {
        return rows[0].getSize();
    }

    public Vector getRow(int rowIndex) {
        if (rowIndex < 0 || rowIndex >= rows.length) {
            throw new IndexOutOfBoundsException("Передан некорректный индекс: " + rowIndex
                    + ". Индекс должен быть в диапазоне от 0 до " + (rows.length - 1));
        }

        return new Vector(rows[rowIndex]);
    }

    public void setRow(int rowIndex, Vector vector) {
        if (rowIndex < 0 || rowIndex >= rows.length) {
            throw new IndexOutOfBoundsException("Передан некорректный индекс: " + rowIndex
                    + ". Индекс должен быть в диапазоне от 0 до " + (rows.length - 1));
        }

        if (vector.getSize() != getColumnsCount()) {
            throw new IllegalArgumentException("Размерность переданного вектора: (" + vector.getSize()
                    + ") должна совпадать с размерностью заменяемого: (" + getColumnsCount() + ")");
        }

        rows[rowIndex] = new Vector(vector);
    }

    public Vector getColumn(int columnIndex) {
        int columnsCount = getColumnsCount();

        if (columnIndex < 0 || columnIndex >= columnsCount) {
            throw new IndexOutOfBoundsException("Передан некорректный индекс: " + columnIndex
                    + ". Индекс должен быть в диапазоне от 0 до " + (columnsCount - 1));
        }

        Vector columnVector = new Vector(rows.length);

        for (int i = 0; i < rows.length; i++) {
            columnVector.setComponent(i, rows[i].getComponent(columnIndex));
        }

        return columnVector;
    }

    public Matrix transpose() {
        int newRowsCount = getColumnsCount();
        Vector[] newRows = new Vector[newRowsCount];

        for (int i = 0; i < newRowsCount; i++) {
            newRows[i] = getColumn(i);
        }

        rows = newRows;
        return this;
    }

    public Matrix multiplyByScalar(double scalar) {
        for (Vector vector : rows) {
            vector.multiplyByScalar(scalar);
        }

        return this;
    }

    private void checkEqualityBySize(Matrix matrix) {
        if (rows.length != matrix.rows.length || getColumnsCount() != matrix.getColumnsCount()) {
            throw new IllegalArgumentException("Данная операция над матрицами возможна только в том случае," +
                    " если они имеют одинаковые размеры. Переданы матрицы размерами: "
                    + rows.length + " x " + getColumnsCount() + " и " + matrix.rows.length + " x " + matrix.getColumnsCount());
        }
    }

    public Matrix add(Matrix matrix) {
        checkEqualityBySize(matrix);

        int rowsCount = getRowsCount();

        for (int i = 0; i < rowsCount; i++) {
            rows[i].add(matrix.rows[i]);
        }

        return this;
    }

    public Matrix subtract(Matrix matrix) {
        checkEqualityBySize(matrix);

        int rowsCount = getRowsCount();

        for (int i = 0; i < rowsCount; i++) {
            rows[i].subtract(matrix.rows[i]);
        }

        return this;
    }

    public Vector multiplyByVector(Vector vector) {
        if (getColumnsCount() != vector.getSize()) {
            throw new IllegalArgumentException("Умножение матрицы на вектор возможно только в том случае, " +
                    "если число столбцов матрицы равно числу строк вектора. " +
                    "Количество столбцов, переданной матрицы: " + getColumnsCount() +
                    ", количество строк вектора: " + vector.getSize());
        }

        int rowsCount = getRowsCount();
        double[] product = new double[rowsCount];

        for (int i = 0; i < rowsCount; i++) {
            product[i] = Vector.getScalarProduct(rows[i], vector);
        }

        return new Vector(product);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("{");

        for (int i = 0; i < rows.length - 1; i++) {
            stringBuilder.append(rows[i]).append(", ");
        }

        stringBuilder.append(rows[rows.length - 1]).append("}");
        return stringBuilder.toString();
    }

    private static double[][] getMinor(double[][] array, int rowIndex) {
        double[][] minor = new double[array.length - 1][array[0].length - 1];

        for (int i = 0, k = 0; i < minor.length; i++, k++) {
            for (int j = 0, m = 0; j < minor[0].length; j++, m++) {
                if (k == rowIndex) {
                    k++;
                }

                if (m == j) {
                    m++;
                }

                minor[i][j] = array[k][m];
            }
        }

        return minor;
    }

    private static double getDeterminant(double[][] array) {
        if (array.length == 1) {
            return array[0][0];
        }

        if (array.length == 2) {
            return array[0][0] * array[1][1] - array[0][1] * array[1][0];
        }

        double determinant = 0;

        for (int i = 0; i < array.length; i++) {
            if (i % 2 == 0) {
                determinant += getDeterminant(getMinor(array, i)) * array[i][0];
            } else {
                determinant -= getDeterminant(getMinor(array, i)) * array[i][0];
            }
        }

        return determinant;
    }

    public double getDeterminant() {
        if (getRowsCount() != getColumnsCount()) {
            throw new UnsupportedOperationException("У матрицы размерами " + getRowsCount() + "x" + getColumnsCount()
                    + "невозможно вычислить определитель. Вычислить определитель можно только у квадратной матрицы");
        }

        return getDeterminant(convertToArray());
    }

    private double[][] convertToArray() {
        int rowsCount = getRowsCount();
        int columnsCount = getColumnsCount();
        double[][] matrixArray = new double[rowsCount][columnsCount];

        for (int i = 0; i < rowsCount; i++) {
            for (int j = 0; j < columnsCount; j++) {
                matrixArray[i][j] = rows[i].getComponent(j);
            }
        }

        return matrixArray;
    }

    public static Matrix getSum(Matrix matrix1, Matrix matrix2) {
        matrix1.checkEqualityBySize(matrix2);

        Matrix matrix1Copy = new Matrix(matrix1);
        return matrix1Copy.add(matrix2);
    }

    public static Matrix getDifference(Matrix matrix1, Matrix matrix2) {
        matrix1.checkEqualityBySize(matrix2);

        Matrix matrix1Copy = new Matrix(matrix1);
        return matrix1Copy.subtract(matrix2);
    }

    public static Matrix getProduct(Matrix matrix1, Matrix matrix2) {
        if (matrix1.getColumnsCount() != matrix2.getRowsCount()) {
            throw new IllegalArgumentException("Перемножение матриц возможно только в том случае, " +
                    "если число столбцов первой матрицы равно числу строк второй. " +
                    "Число столбцов первой матрицы = " + matrix1.getColumnsCount() +
                    ", число строк второй матрицы = " + matrix2.rows.length);
        }

        int newRowsCount = matrix1.getRowsCount();
        int newColumnsCount = matrix2.getColumnsCount();

        double[][] product = new double[newRowsCount][newColumnsCount];

        for (int i = 0; i < newRowsCount; i++) {
            for (int j = 0; j < newColumnsCount; j++) {
                product[i][j] = Vector.getScalarProduct(matrix1.rows[i], matrix2.getColumn(j));
            }
        }

        return new Matrix(product);
    }
}