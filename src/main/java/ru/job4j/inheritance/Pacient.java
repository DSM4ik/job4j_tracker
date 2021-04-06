package ru.job4j.inheritance;

public class Pacient {
    private String name;
    private String surname;
    private int yearsOld;
    private boolean isHealthy;

    @SuppressWarnings("checkstyle:EmptyLineSeparator")
    public boolean getStats() {
        return isHealthy;
    }

}
