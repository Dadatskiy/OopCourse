package dada.oop.matrix_main;

import dada.oop.matrix.Matrix;
import dada.oop.vector.Vector;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        double[][] array = new double[2][4];
        /*for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array[0].length; j++) {
                array[i][j] = 2 * i + 6.5 * j + 7.25 - 3.22 * i * j * j;
            }
        }*/
        double[] components = {5,0};
        Vector vector1 = new Vector(components);

        double[][] arrayV = new double[3][2];
        arrayV[0][0] = 2;    arrayV[0][1] = 5;
        arrayV[1][0] = 20;   arrayV[1][1] = 10;
        arrayV[2][0] = 44;   arrayV[2][1] = 1.5;
        Matrix matrixV = new Matrix(arrayV);

        System.out.println(matrixV);
        System.out.println();
        System.out.println(vector1);
        System.out.println();
        System.out.println(matrixV.multiplyByVector(vector1));



        /*array[0][0] = 2; array[1][0] = 20; //array[0][2] = -111; array[0][3] = 1;
        array[0][1] = 10; array[1][1] = -4; //array[1][2] = 9.37; array[1][3] = -0.23;
        array[0][2] = -10; array[1][2] = 0; //array[2][2] = 47; array[2][3] = -11;
        array[0][3] = -2; array[1][3] = 44; //array[3][2] = 66; array[3][3] = -7;

        double[][] array1 = new double[4][2];
        array1[0][0] = 5;    array1[0][1] = 11;
        array1[1][0] = 15;   array1[1][1] = 22;
        array1[2][0] = 75;   array1[2][1] = 33;
        array1[3][0] = 225;  array1[3][1] = 44;

        Matrix matrix1 = new Matrix(array);
        Matrix matrix2 = new Matrix(array1);

        System.out.println(matrix1);
        System.out.println();
        System.out.println(matrix2);
       System.out.println(Matrix.getProduct(matrix1, matrix2));*/
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
