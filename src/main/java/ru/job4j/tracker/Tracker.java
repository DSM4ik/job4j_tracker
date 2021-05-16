package ru.job4j.tracker;

import java.util.ArrayList;
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
    private ArrayList<Item> items = new ArrayList<Item>();
    //private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        size++;
        items.add(item);
        return item;
    }

    public Item findById(int id) {
        /* Находим индекс */
        int index = indexOf(id);
        /* Если индекс найден возвращаем item, иначе null */
        return index != -1 ? items.get(index) : null;
    }

    public ArrayList<Item> findAll() {
        return items;
    }

    public ArrayList<Item> findByName(String key) {
        ArrayList<Item> rsl = new ArrayList<Item>();

        for (Item itm : items) {
            if (itm.getName().equals(key)) {
                rsl.add(itm);
            }
        }
        return  rsl;
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (Item itm : items) {
            if (itm.getId() == id) {
                rsl = items.indexOf(itm);
            }
        }
        return rsl;
    }

    public boolean replace(int id, Item item) {
        int indexFind = indexOf(id);
        if (indexFind != -1) {
            item.setId(id);
            items.set(indexFind, item);
            return true;
        }
        return false;
    }

    public boolean delete(int id) {
        int indexFind = indexOf(id);
        if (indexFind != -1) {
            items.remove(indexFind);
            size--;
            return true;
        }
        return false;
    }
}