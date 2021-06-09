package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 1. Создайте матрицу Integer[][].
 *
 * 2. Напишите преобразование этой матрицы в список чисел.
 *
 * 3. При решении этой задачи нужно использовать методы flatMap(), collect(), Stream.of().
 *
 * 4. Реализуйте описанную выше логику в методе,
 * который на вход принимает двумерный массив Integer[][]. На реализованный метод напишите тесты.
 */

public class MatrixConvert {
    public static List<Integer> convert(Integer[][] matrix) {
        return Stream.of(matrix)
                .flatMap(Stream::of)
                .collect(Collectors.toList());
    }
}
