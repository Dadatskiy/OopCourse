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

        System.out.println("Длина диапазона ["
                + range.getFrom() + " ; " + range.getTo() + "] = " + range.getLength());

        System.out.print("Введите любое число, чтобы проверить, лежит ли оно в заданном вами диапазоне: ");
        double number = scanner.nextDouble();

        if (range.isInside(number)) {
            System.out.println("Это число лежит в заданном диапазоне.");
        } else {
            System.out.println("Это число не лежит в заданном диапазоне.");
        }

        System.out.print("Задайте заново первое число диапазона: ");
        double newFrom = scanner.nextDouble();

        range.setFrom(newFrom);

        System.out.print("Задайте заново последнее число диапазона: ");
        double newTo = scanner.nextDouble();

        range.setTo(newTo);

        System.out.println("Длина нового диапазона чисел ["
                + range.getFrom() + " ; " + range.getTo() + "] = " + range.getLength());

        System.out.print("Введите любое число, чтобы проверить, лежит ли оно в заданном вами диапазоне: ");
        number = scanner.nextDouble();

        if (range.isInside(number)) {
            System.out.println("Это число лежит в заданном диапазоне.");
        } else {
            System.out.println("Это число не лежит в заданном диапазоне.");
        }
    }
}