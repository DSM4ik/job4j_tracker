package ru.job4j.pojo;

import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setFIO("MickDS");
        student.setGroup(5);
        student.setDateIn(new Date());

        System.out.println("студент " + student.getFIO() + " группа " + student.getGroup() + " Дата поступления " + student.getDateIn());
    }
}
