package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        int countIteration = Math.min(o1.length(), o2.length());
        for (int i = 0; i < countIteration; i++) {
            int rslt = Character.compare(o1.charAt(i), o2.charAt(i));
            if (rslt != 0) {
                return rslt;
            }
        }
        return Integer.compare(o1.length(), o2.length());
    }
}
