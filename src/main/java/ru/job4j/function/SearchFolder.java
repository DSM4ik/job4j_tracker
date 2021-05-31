package ru.job4j.function;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * 1.3. Встроенные функциональные интерфейсы. [#249209]
 */
public class SearchFolder {

    public static List<Folder> filter(List<Folder> list, Predicate<Folder> pred) {
         List<Folder> rsl = new ArrayList<>();
         for (Folder f : list) {
             if (pred.test(f)) {
                 rsl.add(f);
             }
         }
         return rsl;
    }
}
