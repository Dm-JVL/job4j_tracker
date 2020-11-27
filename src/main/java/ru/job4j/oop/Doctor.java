package ru.job4j.oop;

public class Doctor extends Profession {
    private String qualification;

    public Doctor(String nameEn, String surnameEn, String educationEn, String birthdayEn) {
        super(nameEn, surnameEn, educationEn, birthdayEn);
    }

    public Diagnosis heal(Pacient pacient) {
        Diagnosis item = new Diagnosis();
        System.out.println(pacient.getList());
        return item;
    }
}
