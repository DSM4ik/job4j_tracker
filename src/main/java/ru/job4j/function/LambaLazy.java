package ru.job4j.function;

import java.util.Arrays;
import java.util.Comparator;

public class LambaLazy {
    public static void main(String[] args) {
        String[] names = {"Petr", "Petra"};
        Comparator<String> lengthComp = (left, right) -> {
            System.out.println("execute comparator");
            return left.length() - right.length();
        };

        Arrays.sort(names, lengthComp);
    }
}
