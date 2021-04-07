package ru.job4j.inheritance;

public class Builder extends Engineer {
    private String[] usingMaterials;

    public Builder(String name, String surname, String education, String birthday,
                   int experienceYears, String[] usingMaterials) {
        super(name, surname, education, birthday, experienceYears);
        this.usingMaterials = usingMaterials;
    }

    public void buildObject() {

    }
}
