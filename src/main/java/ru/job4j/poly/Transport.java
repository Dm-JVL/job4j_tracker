package ru.job4j.poly;

public interface Transport {
    void go();
    void passenger(int numberPass);
    float refuel(float volume);
}
