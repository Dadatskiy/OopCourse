package dada.oop.matrix_main;

import dada.oop.matrix.Matrix;
import dada.oop.vector.Vector;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        double[][] array1 = new double[2][3];
        
        for (int i = 0; i < array1.length; i++) {
            for (int j = 0; j < array1[0].length; j++) {
                array1[i][j] = 14.4 + i + j;
            }
        }

        Matrix matrix1 = new Matrix(array1);
        System.out.println("matrix1: " + matrix1);
        System.out.println();
        System.out.println("Количество строк матрицы matrix1: " + matrix1.getRowsCount());
        System.out.println();
        System.out.println("Количество столбцов матрицы matrix1: " + matrix1.getColumnsCount());
        System.out.println();

        double[][] array2 = new double[4][2];
        array2[0][0] = 5;
        array2[0][1] = 11;
        array2[1][0] = 15;
        array2[1][1] = 22;
        array2[2][0] = 75;
        array2[2][1] = 33;
        array2[3][0] = 225;
        array2[3][1] = 44;
        Matrix matrix2 = new Matrix(array2);

        double[] components1 = {-10, 41.89};
        Vector vector1 = new Vector(components1);

        System.out.println("matrix2: " + matrix2);
        System.out.println();
        System.out.println("Вектор-строка по индексу 2 матрицы matrix2: " + matrix2.getRow(2));
        System.out.println();
        System.out.println("Вектор-столбец по индексу 1 матрицы matrix2: " + matrix2.getColumn(1));
        System.out.println();
        System.out.println("Заменим вектор-строку по индексу 0 матрицы matrix2 на вектор vector1");
        System.out.println();
        System.out.println("vector1: " + vector1);
        System.out.println();

        matrix2.setRow(0, vector1);
        System.out.println("Теперь matrix2: " + matrix2);
        System.out.println();

        double[][] array3 = new double[4][2];
        array3[0][0] = 2;
        array3[0][1] = 10;
        array3[1][0] = -111;
        array3[1][1] = 1;
        array3[2][0] = 20;
        array3[2][1] = -4;
        array3[3][0] = 9.37;
        array3[3][1] = -0.23;

        Matrix matrix3 = new Matrix(array3);

        System.out.println("matrix3: " + matrix3);
        System.out.println();
        System.out.println("matrix3 x (-8): " + matrix3.multiplyByScalar(-8));
        System.out.println();
        System.out.println("matrix3 после транспонирования: " + matrix3.transpose());
        System.out.println();

        double[][] array4 = new double[5][5];
        Random random = new Random();

        for (int i = 0; i < array4.length; i++) {
            for (int j = 0; j < array4[0].length; j++) {
                array4[i][j] = random.nextDouble(11);
            }
        }

        Matrix matrix4 = new Matrix(array4);

        System.out.println("matrix4: " + matrix4);
        System.out.println();
        System.out.println("Определитель матрицы matrix4 = " + matrix4.getDeterminant());
        System.out.println();

        double[] components2 = {-7, 12.12, 13, 1, -3};
        Vector vector2 = new Vector(components2);

        System.out.println("Вектор vector2: " + vector2);
        System.out.println();
        System.out.println("matrix4 x vector2: " + matrix4.multiplyByVector(vector2));
        System.out.println();

        double[] components3 = {15, 30, 45, 60};
        double[] components4 = {30, 50};
        double[] components5 = {0, 10, 20, 30, 40, 50};

        Vector vector3 = new Vector(components3);
        Vector vector4 = new Vector(components4);
        Vector vector5 = new Vector(components5);

        Vector[] vectors1 = {vector3, vector4, vector5};
        Vector[] vectors2 = {vector4, vector5, vector3};

        Matrix matrix5 = new Matrix(vectors1);
        Matrix matrix6 = new Matrix(vectors2);
        Matrix matrix5Copy = new Matrix(matrix5);
        Matrix matrix6Copy = new Matrix(matrix6);

        System.out.println("matrix5: " + matrix5);
        System.out.println();
        System.out.println("matrix6: " + matrix6);
        System.out.println();
        System.out.println("matrix5 + matrix6: " + matrix5Copy.add(matrix6));
        System.out.println();
        System.out.println("matrix6 - matrix5: " + matrix6Copy.subtract(matrix5));
        System.out.println();
        System.out.println("matrix5: " + matrix5);
        System.out.println();
        System.out.println("matrix6: " + matrix6);
        System.out.println();

        Matrix matrixSum = Matrix.getSum(matrix5, matrix6);
        System.out.println("matrix5 + matrix6: " + matrixSum);
        System.out.println();

        Matrix matrixDifference = Matrix.getDifference(matrix5, matrix6);
        System.out.println("matrix5 - matrix6: " + matrixDifference);
        System.out.println();

        Matrix matrixProduct = Matrix.getProduct(matrix5, matrix6.transpose());
        System.out.println("matrix5 x matrix6(transposed): " + matrixProduct);
        System.out.println();
    }
}