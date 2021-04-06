package ru.job4j.inheritance;

public class Programmer extends Engineer {
    private String[] languageCodes;

    public void showLanguage() {
        for (int i = 0; i < languageCodes.length; i++) {
            System.out.println(languageCodes[i]);
        }
    }
}
