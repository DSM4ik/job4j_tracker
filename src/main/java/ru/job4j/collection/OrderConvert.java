package ru.job4j.collection;

import java.util.HashMap;
import java.util.List;

/**
 * 2. Преобразования List в Map. [#468357]
 * В этой задаче нам нужно преобразовать одну коллекцию в другую.
 * Представим, что в систему поступает список заказов.
 * Нам было бы удобно работать с ним по номеру. Для этого нужно преобразовать список заявок в карту.
 * В качестве ключа установить поле number.
 */
public class OrderConvert {
    public static HashMap<String, Order> process(List<Order> orders) {
        HashMap<String, Order> map = new HashMap<>();
        for (Order o : orders) {
            map.put(o.getNumber(), o);
        }
        return map;
    }
}
