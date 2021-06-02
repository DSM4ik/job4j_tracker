package ru.job4j.function;

import java.util.function.Supplier;

/**
 * Переменную, объявленную вне лямбда-выражения, изменять внутри лямбда-выражения нельзя.
 * В лямбда-выражениях нельзя использовать методы, которые могут выбросить исключения.
 */
public class ScopeInside {
    public static void main(String[] args) {
        int[] number = {1, 2, 3};
        int total = 0;
        for (int i = 0; i < number.length; i++) {
            int num = number[i];
            total = total + add(
                    () -> num
            );
        }
        System.out.println(total);
    }

    private static Integer add(Supplier<Integer> calc) {
        return calc.get();
    }
}
