package ru.job4j.oop;

public class BallStory {
    public static void main(String[] args) {
        System.out.println("PUFF – THE – BALL");
        Ball ball = new Ball();
        Fox fox = new Fox();
        Wolf wolf = new Wolf();
        Hare hare = new Hare();
        hare.tryEat(ball);
        wolf.tryEat(ball);
        fox.tryEat(ball);
    }
}
