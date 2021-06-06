package ru.job4j.comparator;

public class CompareMethod {
    public static int ascendingCompare(int first, int second) {
        return Integer.compare(first, second);
    }

    public static int descendingCompare(int first, int second) {
        return Integer.compare(second, first);
    }

    public static void main(String[] args) {
        int rslt = ascendingCompare(1, 2);
        System.out.println(rslt);

        rslt = descendingCompare(1, 2);
        System.out.println(rslt);
    }
}
