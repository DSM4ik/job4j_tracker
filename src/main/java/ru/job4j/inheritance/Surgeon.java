package ru.job4j.inheritance;

public class Surgeon extends Doctor {
    private boolean isTodayWork;

    public Surgeon(String name, String surname, String education,
                   String birthday, int licenseNumber, boolean isTodayWork) {
        super(name, surname, education, birthday, licenseNumber);
        this.isTodayWork = isTodayWork;
    }

    public void startHeal(Pacient pacient) {

    }
}
