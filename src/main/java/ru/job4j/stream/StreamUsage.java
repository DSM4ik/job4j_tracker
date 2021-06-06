package ru.job4j.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamUsage {
    public static void main(String[] args) {
        List<Integer> lstInteger = List.of(1, -6, 7, -3, 0, 9, 24);

        List<Integer> rsltInteger = lstInteger
                                    .stream()
                                    .filter(n -> n > 0)
                                    .collect(Collectors.toList());
        rsltInteger.forEach(System.out::println);

    }
}
