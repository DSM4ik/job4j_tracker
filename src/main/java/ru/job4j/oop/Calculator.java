package ru.job4j.oop;

public class Calculator {
    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public int multiply(int a) {
        return x * a;
    }

    public static int minus(int b) {
        return b - x;
    }

    public double divide(int c) {
        return (double) c / x;
    }

    public double sumAllOperation(int d) {
        return sum(d) + multiply(d) + minus(d) + divide(d);
    }

    public static void main(String[] args) {
        System.out.println(sum(5));
        System.out.println(minus(3));
        Calculator calculator = new Calculator();
        System.out.println(calculator.divide(2));
        System.out.println(calculator.multiply(3));
        System.out.println(calculator.sumAllOperation(8));

    }
}
