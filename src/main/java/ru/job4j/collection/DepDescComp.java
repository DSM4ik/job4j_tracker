package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        String[] arr1 = o1.split("/");
        String[] arr2 = o2.split("/");

        if (arr2[0].compareTo(arr1[0]) == 0) {
            int CountElCompare = Math.min(arr1.length, arr2.length);
            for (int i = 1; i < CountElCompare; i++) {
                int rslt  = arr1[i].compareTo(arr2[i]);
                if (rslt != 0) {
                    return rslt;
                }
            }
            return Integer.compare(arr1.length, arr2.length);
        }

        return arr2[0].compareTo(arr1[0]);
    }
}
