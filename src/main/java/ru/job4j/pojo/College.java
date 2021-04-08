package ru.job4j.pojo;

import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setDateEntry(new Date());
        student.setFio("Mitskevich Denis Sergeevich");
        student.setGroup(23);

        System.out.println(student.getFio()
                           + "; group - " + student.getGroup()
                           + "Date Entry - " + student.getDateEntry());
    }
}
