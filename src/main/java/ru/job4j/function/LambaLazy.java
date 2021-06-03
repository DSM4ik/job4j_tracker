package ru.job4j.function;

import java.util.Arrays;
import java.util.Comparator;

public class LambaLazy {
    public static void main(String[] args) {
        String[] names = {"Petr", "Petr2"};
        Comparator<String> lengthComp = (left, right) -> {
            System.out.println("left length = " + left.length()
                             + "; right length = " + right.length());
            return Integer.compare(right.length(), left.length());
        };

        for (String str : names) {
            System.out.println(str);
        }

        Arrays.sort(names, lengthComp);

        for (String str : names) {
            System.out.println(str);
        }
    }
}
