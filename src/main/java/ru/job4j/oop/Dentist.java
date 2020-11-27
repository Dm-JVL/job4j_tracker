package ru.job4j.oop;

public class Dentist extends Doctor {
    private String functions[] = {"Diagnostics", "Treatment", "Prevention"};
    public void doctorAppointment(){
    }
    public Dentist(String nameEn, String surnameEn, String educationEn, String birthdayEn) {
        super(nameEn, surnameEn, educationEn, birthdayEn);
    }
}
