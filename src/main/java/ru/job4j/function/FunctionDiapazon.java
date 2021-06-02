package ru.job4j.function;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class FunctionDiapazon {
    public static List<Double> diapason(int start, int end, Function<Double, Double> func) {
        List<Double> lst = new ArrayList<>();
        for (double i = start; i < end; i++) {
            lst.add(func.apply(i));
        }
        return lst;
    }
}
