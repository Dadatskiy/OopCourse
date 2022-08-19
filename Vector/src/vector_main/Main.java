package vector_main;

import vector.Vector;


public class Main {
    public static void main(String[] args) {
        Vector vector0 = new Vector(5);
        System.out.println("Vector 0 " + vector0);
        Vector vector0Copy = new Vector(vector0);
        System.out.println("Vector 0 copy " + vector0Copy);

        double[] components1 = {1, 2, 3, 4, 5};

        Vector vector1 = new Vector(components1);
        System.out.println("Vector 1 " + vector1);
        Vector vector1Copy = new Vector(vector1);
        System.out.println("Vector 1 copy " + vector1Copy);

        System.out.println("Длина вектора 1 = " + vector1.getVectorLength());


        Vector vector2 = new Vector(vector0Copy.addVector(vector1));
        System.out.println("Vector 2 " + vector2);

        System.out.println("Vector 0 " + vector0);
        System.out.println("Vector 0 copy " + vector0Copy);
    }
}