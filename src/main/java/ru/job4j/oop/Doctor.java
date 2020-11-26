package ru.job4j.oop;

public class Doctor extends Profession {
    String qualification;

    public Diagnosis heal(Pacient pacient) {
        Diagnosis item = new Diagnosis();
        System.out.println(pacient.list);
        return item;
    }
}
