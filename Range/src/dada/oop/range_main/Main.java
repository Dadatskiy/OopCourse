package dada.oop.range_main;

import dada.oop.range.Range;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    /*
    public static void printRangesArray(Range[] ranges) {
        if (ranges.length == 0) {
            System.out.println("[]");
        } else if (ranges.length == 1) {
            System.out.println("[" + ranges[0] + "]");
        } else {
            System.out.print("[");

            for (int i = 0; i < ranges.length - 1; i++) {
                System.out.print(ranges[i] + ", ");
            }

            System.out.println(ranges[ranges.length - 1] + "]");
        }
    }
*/
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите первое число диапазона: ");
        double from1 = scanner.nextDouble();

        System.out.print("Введите последнее число диапазона: ");
        double to1 = scanner.nextDouble();

        Range range1 = new Range(from1, to1);

        System.out.println("Длина диапазона " + range1 + " = " + range1.getLength());

        System.out.print("Введите любое число, чтобы проверить, лежит ли оно в заданном вами диапазоне: ");
        double number = scanner.nextDouble();

        if (range1.isInside(number)) {
            System.out.println("Это число лежит в заданном диапазоне.");
        } else {
            System.out.println("Это число не лежит в заданном диапазоне.");
        }

        System.out.print("Задайте заново первое число диапазона: ");
        double from2 = scanner.nextDouble();

        System.out.print("Задайте заново последнее число диапазона: ");
        double to2 = scanner.nextDouble();

        Range range2 = new Range(from2, to2);

        Range intersection = range1.getIntersection(range2);

        if (intersection == null) {
            System.out.println("Заданные интервалы не пересекаются");
        } else {
            System.out.println("Пересечением интервалов " + range1 + " и " + range2 + " является [" + intersection + "]");
        }

        Range[] union = range1.getUnion(range2);

        System.out.print("Объединением интервалов " + range1 + " и " + range2 + " является: ");
        //printRangesArray(union);
        System.out.println(Arrays.toString(union));

        Range[] difference = range1.getDifference(range2);

        System.out.print("Несимметричной разностью интервалов " + range1 + " и " + range2 + " является: ");
        //printRangesArray(difference);
        System.out.println(Arrays.toString(difference));
    }
}