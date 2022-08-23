package vector_main;

import vector.Vector;


public class Main {
    public static void main(String[] args) {
        Vector vector0 = new Vector(5);
        System.out.println("Vector 0: " + vector0);
        Vector vector0Copy = new Vector(vector0);
        System.out.println("Vector 0 copy: " + vector0Copy);

        vector0.revertVector();
        System.out.println("Оригинал: " + vector0Copy);
        System.out.println("Копия: " + vector0Copy);
    }
}