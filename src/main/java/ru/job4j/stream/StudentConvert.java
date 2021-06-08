package ru.job4j.stream;

import javax.print.DocFlavor;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 4. Преобразование List в Map. [#110226]
 * 1. Создать список учеников. Класс Student взять из задания "Фильтрация учеников".
 *
 * 2. Преобразовать список учеников в Map.
 *
 * 3. В качестве ключа использовать фамилию ученика.
 *
 * 4. В качестве значение использовать объект ученика.
 */
public class StudentConvert {
    public static Map<String, Student> convert(List<Student> students) {
        return students
                    .stream()
                    .collect(Collectors.toMap(
                                             s -> s.getSurname(),
                                             s -> s,
                                             (val1, val2) -> val1
                                             )
                            );
    }
}
