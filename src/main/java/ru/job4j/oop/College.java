package ru.job4j.oop;

public class College {
    public static void main(String[] args) {
        Freshman fresh = new Freshman();
        Student st = fresh; //UpCast!
        Object ob = fresh;
    }
}
