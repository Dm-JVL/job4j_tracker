package ru.job4j.poly;

public class Bus implements Transport{

    @Override
    public void go() {
        System.out.println("Go");
    }

    @Override
    public void passenger(int numberPass) {
        System.out.println("Number of passengers: "+numberPass);
    }

    @Override
    public float refuel(float volume) {
        float price = (float) 1.25;
        return price*volume;
    }
}
