package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int leftInt = Integer.parseInt(left.substring(0, left.indexOf(" ")).replace(".", ""));
        int rightInt = Integer.parseInt(right.substring(0, right.indexOf(" ")).replace(".", ""));

        return Integer.compare(leftInt, rightInt);
    }
}
