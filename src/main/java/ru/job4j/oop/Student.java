package ru.job4j.oop;

public class Student {

    public void music(String lyrics) {
        System.out.println("I can sign a song : " + lyrics);
    }

    public void song() {
        System.out.println("I believe, a can fly");
    }

    public static void main(String[] args) {
        Student petya = new Student();
        for (int i = 1; i <= 3; i++) {
            petya.music("I believe, I can fly");
            petya.song();
        }
    }
}
