package ru.job4j.inheritance;

public class Doctor extends Profession {
    private int licenseNumber;

    public Diagnosis heal(Pacient pacient) {
        Diagnosis dg = new Diagnosis();
        if (pacient.getStats()) {
            dg.setAboutDiagnos("All right");
        } else {
            dg.setAboutDiagnos("All too bad");
        }

        return dg;
    }
}
