package dada.oop.range_main;

import dada.oop.range.Range;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите первое число диапазона: ");
        double from = scanner.nextDouble();

        System.out.print("Введите последнее число диапазона: ");
        double to = scanner.nextDouble();

        Range range = new Range(from, to);

        System.out.println("Длина диапазона (" + range.getFrom() + " ; " + range.getTo() + ") = " + range.getLength());

        System.out.print("Введите любое число, чтобы проверить, лежит ли оно в заданном вами диапазоне: ");
        double number = scanner.nextDouble();

        if (range.isInside(number)) {
            System.out.println("Это число лежит в заданном диапазоне.");
        } else {
            System.out.println("Это число не лежит в заданном диапазоне.");
        }

        System.out.print("Задайте заново первое число диапазона: ");
        double newFrom = scanner.nextDouble();

        System.out.print("Задайте заново последнее число диапазона: ");
        double newTo = scanner.nextDouble();

        Range intersectionRange = range.getIntersection(newFrom, newTo);

        if (intersectionRange == null) {
            System.out.println("Заданные интервалы не пересекаются");
        } else {
            System.out.println("Интервал пересечения двух интервалов: "
                    + "(" + intersectionRange.getFrom() + ", " + intersectionRange.getTo() + ")");
        }

        Range [] unionRange = range.getUnion(newFrom, newTo);

        if (unionRange == null) {
            System.out.println("Заданные интервалы невозможно объединить");
        }
        else if (unionRange.length == 1) {
            System.out.println("Интервал объединения двух интервалов: " + "(" + unionRange[0].getFrom() + ", " + unionRange[0].getTo()+ ")");
        } else {
            System.out.println("Интервалы объединения двух интервалов: "
                    + "(" + unionRange[0].getFrom() + ", " + unionRange[0].getTo() + "), ("
                    + unionRange[1].getFrom() + ", " + unionRange[1].getTo() + ")");
        }


        Range [] differenceRange = range.getDifference(newFrom, newTo);

        if (differenceRange == null) {
            System.out.println("Нессимитричая разность данных интервалов отсутствует.");
        } else if (differenceRange.length == 1) {
            System.out.println("Интервал разности двух интервалов: " + "(" + differenceRange[0].getFrom() + ", " + differenceRange[0].getTo()+ ")");
        } else if (differenceRange.length == 2) {
            System.out.println("Интервалы разности двух интервалов: "
                    + "(" + differenceRange[0].getFrom() + ", " + differenceRange[0].getTo() + "), ("
                    + differenceRange[1].getFrom() + ", " + differenceRange[1].getTo() + ")");
        }
    }
}