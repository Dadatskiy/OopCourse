package dada.oop.vector_main;

import dada.oop.vector.Vector;

public class Main {
    public static void main(String[] args) {
        Vector vector0 = new Vector(2);

        System.out.println("Вектор 0: " + vector0);

        vector0.setComponent(0, -66);
        vector0.setComponent(0, 11);

        System.out.println("Вектор 0 после заполнения координат: " + vector0);
        System.out.println();

        double[] components1 = {1, 3, 5};
        Vector vector1 = new Vector(components1);

        System.out.println("Вектор 1: " + vector1);
        System.out.println("Размерность вектора 1 = " + vector1.getSize());
        System.out.println("Длина вектора 1 = " + vector1.getLength());
        System.out.println();

        double[] components2 = {2, 4, 6, 7, 9, -10};
        Vector vector2 = new Vector(components2);

        System.out.println("Вектор 2: " + vector2);
        System.out.println("Размерность вектора 2 = " + vector2.getSize());
        System.out.println("Длина вектора 2 = " + vector2.getLength());
        System.out.println();

        System.out.println("Вектор 1 + Вектор 2 = " + vector1 + " + " + vector2 + " = "
                + new Vector(vector1).add(new Vector(vector2)));

        System.out.println("Не копия" + vector1);

        System.out.println("Вектор 1 - Вектор 2 = " + vector1 + " - " + vector2 + " = "
                + new Vector(vector1).subtract(new Vector(vector2)));
        System.out.println();

        double[] components3 = {10, 20, 30, 40, 50, 666};
        Vector vector3 = new Vector(7, components3);

        System.out.println("Вектор 3: " + vector3);
        System.out.println("Развернутый вектор 3: " + new Vector(vector3).revert());

        double scalar = 2.71;
        System.out.println("Вектор 3, умноженный на скаляр = " + vector3 + " * " + scalar + " = "
                + new Vector(vector3).multiplyByScalar(scalar));
        System.out.println();

        double[] components4 = {1, 5, 25, 125, 625, 3125};
        Vector vector4 = new Vector(components4);

        System.out.println("Вектор 4: " + vector4);

        System.out.println("Хэш-код вектора 4 = " + vector4.hashCode());
        System.out.println();

        Vector vector5 = new Vector(6);

        for (int i = 0; i < vector5.getSize(); i++) {
            vector5.setComponent(i, Math.pow(5, i));
        }

        System.out.println("Вектор 5: " + vector5);
        System.out.println("Результат проверки на равенство вектора 4 и вектора 5: " + vector4.equals(vector5));
        System.out.println();

        System.out.println("Вектор 4 + Вектор 4 = " + vector4 + " + " + vector4 + " = "
                + Vector.getSum(new Vector(vector4), new Vector(vector4)));
        System.out.println();

        System.out.println("Вектор 3 - Вектор 5 = " + vector3 + " - " + vector5 + " = "
                + Vector.getDifference(new Vector(vector3), new Vector(vector5)));
        System.out.println();

        System.out.println("Вектор 0 х Вектор 2 = " + vector0 + " х " + vector2 + " = "
                + Vector.getScalarProduct(new Vector(vector0), new Vector(vector2)));
    }
}