package ru.job4j.oop;

/**
 * повышающее приведение;
 */
public class College {
    public static void main(String[] args) {
        Freshman fr = new Freshman();
        Student st = fr;
        Object ob = st;
    }
}
