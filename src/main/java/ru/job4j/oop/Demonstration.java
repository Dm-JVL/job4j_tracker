package ru.job4j.oop;

public class Demonstration {
    public static void main(String[] args) {
        Vehicle bus = new Bus();
        Vehicle busw = new Bus();
        Vehicle tr = new Train();
        Vehicle trw = new Train();
        Vehicle pl = new Plane();
        Vehicle plw = new Plane();
        Vehicle[] ts = new Vehicle[]{bus, busw, tr, trw, pl, plw};
        for (Vehicle a : ts) {
            a.move();
        }
    }
}

