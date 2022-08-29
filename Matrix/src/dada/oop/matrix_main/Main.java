package dada.oop.matrix_main;

import dada.oop.matrix.Matrix;
import dada.oop.vector.Vector;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        double[][] array = new double[5][3];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                array[i][j] = 2 * i + 5 * j;
            }
        }

        Matrix matrix = new Matrix(array);

        System.out.println(array.length);
        System.out.println(matrix);
        System.out.println();
        System.out.println(matrix.transpose());

/*
        int length = array.length;
        System.out.println(length);
        System.out.println(matrix);

        double[] components1 = {15, 30, 45, 60};
        double[] components2 = {30, 50};
        double[] components3 = {0, 10, 20, 30, 40, 50};


        Vector vector1 = new Vector(components1);
        Vector vector2 = new Vector(components2);
        Vector vector3 = new Vector(components3);

        Vector[] vectors = {vector1, vector2, vector3};

        Matrix matrix = new Matrix(vectors);
        System.out.println(Arrays.toString(matrix.getMatrixSizes()));
 */

    }
}
