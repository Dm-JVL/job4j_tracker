package ru.job4j.oop;

public class Surgeon extends Doctor {
    private String typeOfOperation;

    public Surgeon(String nameEn, String surnameEn, String educationEn, String birthdayEn) {
        super(nameEn, surnameEn, educationEn, birthdayEn);
    }

    public void operationRealized() {
    }
}