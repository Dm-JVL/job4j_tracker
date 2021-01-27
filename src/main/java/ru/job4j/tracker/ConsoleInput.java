package ru.job4j.tracker;

import java.util.Scanner;

public class ConsoleInput implements Input {
    private final Output out;
    private Scanner scanner = new Scanner(System.in);

    public ConsoleInput(Output out) {
        this.out = out;
    }

    @Override
    public String askStr(String question) {
        out.println(question);
        return scanner.nextLine();
    }

    @Override
    public int askInt(String question) {
        return Integer.valueOf(askStr(question));
    }
}