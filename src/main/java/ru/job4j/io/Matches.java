package ru.job4j.io;

import java.util.Scanner;

public class Matches {
    public static boolean isNumber(String s) {
        try {
            int i = Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public static int vvod(int gamerNum) {
        Scanner in = new Scanner(System.in);
        boolean inter = false;
        int ans = 0;
        System.out.println("Вводит " + (gamerNum + 1) + "-й игрок! ");
        do {
            String buf = in.nextLine();
            if (isNumber(buf) && (Integer.valueOf(buf)>0 && Integer.valueOf(buf)<4)) {
                return Integer.valueOf(buf);
              } else {
                    System.out.println("Введите еще раз!");
                }
        } while (true);
   }

    public static void main(String[] args) {
        System.out.println("Игра \"11\"");
        System.out.println("На столе лежат 11 спичек. Два игрока по очереди берут от 1 до 3 спичек. Выигрывает тот, кто забрал последние спички.");
        System.out.println("Игра началась!");
        int matches = 11;
        int ans = 0;
        do {
            for (int i = 0; i < 2; i++) {
                ans = vvod(i);
                matches = matches - ans;
                if (matches <= 0) {
                    System.out.println("Выйграл " + (i + 1) + "-й игрок!\nИгра окончена!");
                    break;
                }
            }
        } while (matches > 0);
    }
}