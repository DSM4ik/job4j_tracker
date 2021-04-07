package ru.job4j.inheritance;

public class Engineer extends Profession {
    private int experienceYears;

    public Engineer(String name, String surname, String education,
                    String birthday, int experienceYears) {
        super(name, surname, education, birthday);
        this.experienceYears = experienceYears;
    }
}
