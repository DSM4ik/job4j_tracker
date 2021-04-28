package ru.job4j.ex;

public class Fact {
    public static void main(String[] args) {
        Fact fact = new Fact();
        int factResult = fact.calc(-3);
    }

    public int calc(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Входящий параметр не должен быть <0");
        }
        int rsl = 1;
        for (int index = 1; index <= n; index++) {
            rsl *= index;
        }
        return rsl;
    }
}
