package ru.job4j.collection;

import java.util.HashSet;

public class Arcticle {
    public static boolean generateBy(String origin, String line) {
        HashSet<String> originText = new HashSet<>();
        String[] words = origin.replaceAll("[^a-zA-Zа-яА-Я]", " ").split(" ");
        String[] newWords = line.split(" ");

        for (String word : words) {
            originText.add(word);
        }

        for (String newWord : newWords) {
            if (!originText.contains(newWord)) {
                return false;
            }
        }
        return true;
    }
}
