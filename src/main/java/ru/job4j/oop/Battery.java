package ru.job4j.oop;

public class Battery {
    private int load;

    public Battery(int size) {
        this.load = size;
    }

    public void exchange(Battery another) {
        another.load+=this.load;
        this.load=0;
    }

    public static void main(String[] args) {
        Battery batteryOne = new Battery(50);
        Battery batteryTwo = new Battery(75);
        batteryTwo.exchange(batteryOne);
        System.out.println("Заряд батареи 1: " + batteryOne.load);
        System.out.println("Заряд батареи 2: " + batteryTwo.load);
    }
}
