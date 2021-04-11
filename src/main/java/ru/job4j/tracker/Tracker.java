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
 * Метод private int indexOf(int id) - возврашает index по id
 *
 * Метод public boolean replace(int id, Item item) - метод замены заявки
 *
 * public boolean delete(int id) - метод удаления заявки
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
        /* Находим индекс */
        int index = indexOf(id);
        /* Если индекс найден возвращаем item, иначе null */
        return index != -1 ? items[index] : null;
    }

    public Item[] findAll() {
        return Arrays.copyOf(items, size);
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

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < size; index++) {
            if (items[index].getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public boolean replace(int id, Item item) {
        int indexFind = indexOf(id);
        if (indexFind != -1) {
            item.setId(id);
            items[indexFind] = item;
            return true;
        }
        return false;
    }

    public boolean delete(int id) {
        int indexFind = indexOf(id);
        if (indexFind != -1) {
            System.arraycopy(items, indexFind + 1, items, indexFind, size - indexFind - 1);
            items[size - 1] = null;
            size--;
            return true;
        }
        return false;
    }
}