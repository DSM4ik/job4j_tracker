package ru.job4j.tracker;

import java.util.Arrays;

/**
 * -Метод public Item add(Item item) добавляет заявку,
 * переданную в аргументах в массив заявок items.
 *
 * -Метод public Item findById(int id) проверяет в цикле все элементы массива items,
 * сравнивая id с аргументом int id и возвращает найденный Item.
 * Если Item не найден - возвращает null.
 *
 * -Метод public Item[] findAll() возвращает копию массива items без null элементов
 * (без пустых ячеек).
 *
 * -Метод public Item[] findByName(String key) проверяет в цикле все элементы массива items,
 * сравнивая name (используя метод getName класса Item) с аргументом метода String key.
 * Элементы, у которых совпадает name, копирует в результирующий массив и возвращает его.
 * Алгоритм этого метода аналогичен методу findAll.
 *
 *
 */
public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item findById(int id) {
        Item rsl = null;
        for (int index = 0; index < size; index++) {
            Item item = items[index];
            if (item.getId() == id) {
                rsl = item;
                break;
            }
        }
        return rsl;
    }

    public Item[] findAll() {
        Item[] rsl = new Item[size];
        int indexRsl = 0;
        for (int i = 0; i < size; i++) {
            if (items[i] != null) {
                rsl[indexRsl++] = items[i];
            }
        }
        return Arrays.copyOf(rsl, indexRsl);
    }

    public Item[] findByName(String key) {
        Item[] rsl = new Item[size];
        int indexRsl = 0;
        for (int i = 0; i < size; i++) {
            if (items[i].getName().equals(key)) {
                rsl[indexRsl++] = items[i];
            }
        }
        return  Arrays.copyOf(rsl, indexRsl);
    }
}