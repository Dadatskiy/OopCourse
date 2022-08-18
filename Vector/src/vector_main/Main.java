package vector_main;

import vector.Vector;

public class Main {
    public static void main(String[] args) {
        Vector vector = new Vector(4);

        Vector copyVector = new Vector(vector);

        double [] components = {40,-98.33,-2,0,45,-45,8888};

        Vector vector1 = new Vector(components);

        System.out.println(vector1);
        System.out.println(vector.getSize());
    }
}
