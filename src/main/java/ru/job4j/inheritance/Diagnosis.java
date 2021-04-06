package ru.job4j.inheritance;

public class Diagnosis {

    private String aboutDiagnos;
    private Doctor doctorGiveDiagnos;

    public String getAboutDiagnos() {
        return aboutDiagnos;
    }

    public void setAboutDiagnos(String aboutDiagnos) {
        this.aboutDiagnos = aboutDiagnos;
    }

    public Doctor getDoctorGiveDiagnos() {
        return doctorGiveDiagnos;
    }

}
