package ru.job4j.pojo;

import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setFullName("Ivan Ivanovich Ivanov");
        student.setDateOfAdmission(new Date());
        student.setGroup("№102");

        System.out.println(student.getFullName() + System.lineSeparator()+
                " Date date of admission: " + student.getDateOfAdmission() + System.lineSeparator()+
                " Group: " + student.getGroup());
    }
}
