package ru.job4j.oop;

public class Train implements Vehicle{
    public void move() {
        System.out.println(getClass().getSimpleName() + " ездит по рельсам.");
    }
}
