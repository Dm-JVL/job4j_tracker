package ru.job4j.oop;

public class Ball {
    public void show(int variant) {
        switch (variant) {
            case 1:
                System.out.println("Ball: Hello! Who are you?");
                break;
            case 2:
                System.out.println("Ball: I’ m Puff – the – Ball. I’ m yellow, big and sweet.");
                break;
            case 3:
                System.out.println("Ball: Oh, please, don’ t eat me! I will dance for you.");
                break;
            default:
                break;
        }
    }
}
