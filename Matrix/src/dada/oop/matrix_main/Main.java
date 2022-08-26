package dada.oop.matrix_main;

import dada.oop.matrix.Matrix;

public class Main {
    public static void main(String[] args) {

        double[][] array = new double[4][4];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                array[i][j] = 2 * i + 5 * j;
            }
        }

        Matrix matrix = new Matrix(array);


        int length = array.length;
        System.out.println(length);
        System.out.println(matrix);




    }
}
