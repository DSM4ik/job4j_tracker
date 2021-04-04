package ru.job4j.oop;

public class Jar {
    private int value;

    public Jar(int value) {
        this.value = value;
    }

    public void poor(Jar another) {
        this.value = this.value + another.value;
        another.value = 0;
    }

    public static void main(String[] args) {
        Jar first = new Jar(10);
        Jar second = new Jar(5);

        System.out.println("first : " + first.value + ". second : " + second.value);
        first.poor(second);
        System.out.println("first : " + first.value + ". second : " + second.value);

    }
}
