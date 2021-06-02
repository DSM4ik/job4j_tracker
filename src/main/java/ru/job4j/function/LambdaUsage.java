package ru.job4j.function;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 2.2. Лямбда блок [#249208]
 */
public class LambdaUsage {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Pet", "Ivvanio", "Anton", "Valeraaaaa");
        Comparator<String> namesComp = (name1, name2) -> {
            System.out.println("Element- " + name1 + " compare to Element -" + name2);
            return name2.length() - name1.length();
        };

        names.sort(namesComp);

        System.out.println(names);
    }
}
