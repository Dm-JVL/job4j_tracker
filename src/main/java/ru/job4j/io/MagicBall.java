package ru.job4j.io;

import java.util.Random;
import java.util.Scanner;

public class MagicBall {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Я великий Оракул. Что ты хочешь узнать? ");
        String str = input.nextLine();
        int rand = new Random().nextInt(3);
        System.out.println("Мой ответ:");
        switch (rand) {
            case 0: {
                System.out.println("Да");
                break;
            }
            case 1: {
                System.out.println("Нет");
                break;
            }
            default:{
                System.out.println("Может быть");
                break;
            }
        }
    }
}
