package ru.job4j.oop;

/**
 * перегрузка метода
 */
public class Max {

    public static int max(int a, int b) {
        return a >= b ? a : b;
    }

    public static int max(int a, int b, int c) {
        return (max(a, b) == a && max(a, c) == a) ? a : (max(a, b) == b && max(b, c) == b) ? b : c;
    }

}
