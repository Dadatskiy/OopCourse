package dada.oop.matrix_main;

import dada.oop.matrix.Matrix;
import dada.oop.vector.Vector;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        double[][] array0 = new double[2][3];
        for (int i = 0; i < array0.length; i++) {
            for (int j = 0; j < array0[0].length; j++) {
                array0[i][j] = 14.4 + i + j;
            }
        }

        Matrix matrix0 = new Matrix(array0);
        System.out.println("matrix0: " + matrix0);
        System.out.println();
        System.out.println("Количество строк матрицы matrix0: " + matrix0.getRowsCount());
        System.out.println();
        System.out.println("Количество столбцов матрицы matrix0: " + matrix0.getColumnsCount());
        System.out.println();

        double[][] array1 = new double[4][2];
        array1[0][0] = 5;
        array1[0][1] = 11;
        array1[1][0] = 15;
        array1[1][1] = 22;
        array1[2][0] = 75;
        array1[2][1] = 33;
        array1[3][0] = 225;
        array1[3][1] = 44;
        Matrix matrix1 = new Matrix(array1);

        double[] components0 = {-10, 41.89};
        Vector vector0 = new Vector(components0);

        System.out.println("matrix1: " + matrix1);
        System.out.println();
        System.out.println("Вектор-строка по индексу 2 матрицы matrix1: " + matrix1.getRowVector(2));
        System.out.println();
        System.out.println("Вектор-столбец по индексу 1 матрицы matrix1: " + matrix1.getColumnVector(1));
        System.out.println();
        System.out.println("Заменим вектор-строку по индексу 0 на вектор vector0");
        System.out.println();

        matrix1.setRowVector(0, vector0);
        System.out.println("Теперь matrix1: " + matrix1);
        System.out.println();

        double[][] array2 = new double[4][2];
        array2[0][0] = 2;
        array2[0][1] = 10;
        array2[1][0] = -111;
        array2[1][1] = 1;
        array2[2][0] = 20;
        array2[2][1] = -4;
        array2[3][0] = 9.37;
        array2[3][1] = -0.23;

        Matrix matrix2 = new Matrix(array2);

        System.out.println("matrix2: " + matrix2);
        System.out.println();
        System.out.println("matrix2 x (-8): " + matrix2.multiplyByScalar(-8));
        System.out.println();
        System.out.println("matrix2 после транспонирования: " + matrix2.transpose());
        System.out.println();

        double[][] array3 = new double[5][5];
        Random random = new Random();

        for (int i = 0; i < array3.length; i++) {
            for (int j = 0; j < array3[0].length; j++) {
                array3[i][j] = random.nextDouble(11);
            }
        }

        Matrix matrix3 = new Matrix(array3);

        System.out.println("matrix3: " + matrix3);
        System.out.println();
        System.out.println("Определитель матрицы matrix3 = " + matrix3.getDeterminant());
        System.out.println();

        double[] components1 = {-7, 12.12, 13, 1, -3};
        Vector vector1 = new Vector(components1);

        System.out.println("Вектор vector1: " + vector1);
        System.out.println();
        System.out.println("matrix3 x vector1: " + matrix3.multiplyByVector(vector1));
        System.out.println();

        double[] components2 = {15, 30, 45, 60};
        double[] components3 = {30, 50};
        double[] components4 = {0, 10, 20, 30, 40, 50};

        Vector vector2 = new Vector(components2);
        Vector vector3 = new Vector(components3);
        Vector vector4 = new Vector(components4);

        Vector[] vectors1 = {vector2, vector3, vector4};
        Vector[] vectors2 = {vector3, vector4, vector2};

        Matrix matrix4 = new Matrix(vectors1);
        Matrix matrix5 = new Matrix(vectors2);
        Matrix matrix4Copy = new Matrix(matrix4);
        Matrix matrix5Copy = new Matrix(matrix5);

        System.out.println("matrix4: " + matrix4);
        System.out.println();
        System.out.println("matrix5: " + matrix5);
        System.out.println();
        System.out.println("matrix4 + matrix5: " + matrix4Copy.add(matrix5));
        System.out.println();
        System.out.println("matrix5 - matrix4: " + matrix5Copy.subtract(matrix4));
        System.out.println();
        System.out.println("matrix4: " + matrix4);
        System.out.println();
        System.out.println("matrix5: " + matrix5);
        System.out.println();

        Matrix matrixSum = Matrix.getSum(matrix4, matrix5);
        System.out.println("matrix4 + matrix5: " + matrixSum);
        System.out.println();

        Matrix matrixDifference = Matrix.getDifference(matrix4, matrix5);
        System.out.println("matrix4 - matrix5: " + matrixDifference);
        System.out.println();

        Matrix matrixProduct = Matrix.getProduct(matrix4, matrix5.transpose());
        System.out.println("matrix4 x matrix5(transposed): " + matrixProduct);
        System.out.println();
    }
}