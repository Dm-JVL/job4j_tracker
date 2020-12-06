package ru.job4j.oop;

public class Plane implements Vehicle{
    public void move() {
        System.out.println(getClass().getSimpleName() + " летает в облаках.");
    }

}
