package ru.job4j.inheritance;

public class Dentist extends Doctor {
    private String[] instrumentsDentist;

    public Dentist(String name, String surname, String education, String birthday,
                   int licenseNumber, String[] instrumentsDentist) {
        super(name, surname, education, birthday, licenseNumber);
        this.instrumentsDentist = instrumentsDentist;
    }

    public void showInstrument() {

    }
}
