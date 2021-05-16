package ru.job4j.collection;

import java.util.ArrayList;
import java.util.List;

/**
 * Конвертация листа массивов в один лист Integer
 */
public class ConvertList {
    public static List<Integer> convert(List<int[]> list) {
        List<Integer> rsl = new ArrayList<>();
        /// for-each
        for (int[] arr : list) {
            for (int cell : arr) {
                rsl.add(cell);
            }
        }
        return rsl;

    }
}
