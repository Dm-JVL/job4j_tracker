package ru.job4j.oop;

public class Hare {
    public void tryEat(Ball ball) {
        System.out.println("Storyteller: Puff-the-Ball met a Hare.");
        ball.show(1);
        this.show(1);
        ball.show(2);
        this.show(2);
        ball.show(3);
        System.out.println("Storyteller: Hare not eat the ball!");
    }

    public void show(int variant) {
        switch (variant) {
            case 1:
                System.out.println("Hare: Hello! I’ m a Hare. And who are you?");
                break;
            case 2:
                System.out.println("Hare: Good! I will eat you!");
                break;
            default:
                break;
        }
    }
}
