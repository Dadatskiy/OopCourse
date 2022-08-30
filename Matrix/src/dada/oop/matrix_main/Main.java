package dada.oop.matrix_main;

import dada.oop.matrix.Matrix;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        double[][] array = new double[4][4];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                array[i][j] = 2 * i + 6.5 * j + 7.25;
            }
        }

        double [][] array1 = new double[2][2];
        array1[0][0] = 11;
        array1[0][1] = -3;
        array1[1][0] = -15;
        array1[1][1] = -2;

        Matrix matrix1 = new Matrix(array);
        Matrix matrix2 = new Matrix(array1);

        System.out.println(matrix1);
        System.out.println();
        System.out.println(matrix2);
        System.out.println(matrix2.getSub(matrix2.getArray()));
/*
        System.out.println(matrix1.getSub(matrix1.array));*/

/*
        System.out.println(Matrix.getSum(matrix1,matrix2));



        System.out.println(array.length);
        System.out.println(matrix1);
        System.out.println();
        System.out.println(matrix1.multiByScalar(-3));
        System.out.println();
        System.out.println(matrix1.transpose());


        int length = array.length;
        System.out.println(length);
        System.out.println(matrix1);

        double[] components1 = {15, 30, 45, 60};
        double[] components2 = {30, 50};
        double[] components3 = {0, 10, 20, 30, 40, 50};


        Vector vector1 = new Vector(components1);
        Vector vector2 = new Vector(components2);
        Vector vector3 = new Vector(components3);

        Vector[] vectors = {vector1, vector2, vector3};

        Matrix matrix1 = new Matrix(vectors);
        System.out.println(Arrays.toString(matrix1.getMatrixSizes()));
 */

    }
}
