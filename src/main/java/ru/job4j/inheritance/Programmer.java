package ru.job4j.inheritance;

public class Programmer extends Engineer {
    private String[] languageCodes;

    public Programmer(String name, String surname, String education,
                      String birthday, int experienceYears, String[] languageCodes) {
        super(name, surname, education, birthday, experienceYears);
        this.languageCodes = languageCodes;
    }

    public void showLanguage() {
        for (int i = 0; i < languageCodes.length; i++) {
            System.out.println(languageCodes[i]);
        }
    }
}
