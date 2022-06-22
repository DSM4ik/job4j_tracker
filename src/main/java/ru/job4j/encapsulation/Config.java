package ru.job4j.encapsulation;
/**
        * общее правило в курсе.
        *
        * 1. Для всех полей используем только модификатор private.
        * 2. Для классов - public. Во второй и третьей части курса так же применим для классов private.
        * 3. Для методов - public или private. Общее правило,
        * если метод имеет модификатор default или protected его нужно переделать на public
 */
public class Config {
    private String name;
    private int position;
    private String[] properties;

    public Config(String name) {
        this.name = name;
    }

    public void print() {
        System.out.println(position);
    }

    public String getProperty(String key) {
        return search(key);
    }

    private String search(String key) {
        return key;
    }
}
