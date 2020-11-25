package ru.job4j.oop;

public class Jukebox {
    public void music(int index) {
       if (index == 1) {
            System.out.println("Пусть бегут неуклюже");
        } else if (index == 2) {
            System.out.println("Спокойной ночи");
        } else {
            System.out.println("Песня не найдена");
        }
    }

    public static void main(String[] args) {
        Jukebox item = new Jukebox();
        for (int i = 1; i < 4; i++) {
            item.music(i);
        }
    }
}
