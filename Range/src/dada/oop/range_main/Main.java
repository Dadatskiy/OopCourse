package dada.oop.range_main;

import dada.oop.range.Range;

import java.util.Scanner;

public class Main {
    public static void printRangesArray(Range[] ranges) {
        if (ranges.length == 0) {
            System.out.println("[]");
        } else if (ranges.length == 1) {
            System.out.println("[" + ranges[0] + "]");
        } else {
            System.out.print("[" + ranges[0] + ", ");

            for (int i = 1; i < ranges.length - 1; i++) {
                System.out.print(ranges[i] + ", ");
            }

            System.out.println(ranges[ranges.length - 1] + "]");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите первое число диапазона: ");
        double from1 = scanner.nextDouble();

        System.out.print("Введите последнее число диапазона: ");
        double to1 = scanner.nextDouble();

        Range range = new Range(from1, to1);

        System.out.println("Длина диапазона " + range + " = " + range.getLength());

        System.out.print("Введите любое число, чтобы проверить, лежит ли оно в заданном вами диапазоне: ");
        double number = scanner.nextDouble();

        if (range.isInside(number)) {
            System.out.println("Это число лежит в заданном диапазоне.");
        } else {
            System.out.println("Это число не лежит в заданном диапазоне.");
        }

        System.out.print("Задайте заново первое число диапазона: ");
        double from2 = scanner.nextDouble();

        System.out.print("Задайте заново последнее число диапазона: ");
        double to2 = scanner.nextDouble();

        Range range1 = new Range(from2, to2);

        if (range.getIntersection(range1) == null) {
            System.out.println("Заданные интервалы не пересекаются");
        } else {
            System.out.println("Пересечением интервалов " + range + " и " + range1 + " является [" + range.getIntersection(range1) + "]");
        }

        Range[] union = range.getUnion(range1);

        System.out.print("Объединением интервалов " + range + " и " + range1 + " является: ");
        printRangesArray(union);

        Range[] difference = range.getDifference(range1);

        System.out.print("Несимметричной разностью интервалов " + range + " и " + range1 + " является: ");
        printRangesArray(difference);
    }
}