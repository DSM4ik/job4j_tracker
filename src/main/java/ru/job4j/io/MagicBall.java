package ru.job4j.io;
/**
 * В этом задании нужно реализовать предсказателя.
 * Пользователь вводит вопрос, программа генерирует
 * случайное число и выводит ответ на вопрос пользователя: да, нет, может быть.
 */

import java.util.Random;
import java.util.Scanner;

public class MagicBall {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String question = input.nextLine();
        int answer = new Random().nextInt(3);
        System.out.println(answer);
        switch (answer) {
            case (0):
                System.out.println("Да");
                break;
            case (1):
                System.out.println("Нет");
                break;
            default:
                System.out.println("Может быть");
        }
    }
}
