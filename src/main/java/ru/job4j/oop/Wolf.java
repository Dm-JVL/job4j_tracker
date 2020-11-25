package ru.job4j.oop;

public class Wolf {
    public void tryEat(Ball ball){
        System.out.println("Storyteller: Puff-the-Ball met a Wolf.");
        ball.show(1);
        this.show(1);
        ball.show(2);
        this.show(2);
        ball.show(3);
        System.out.println("Storyteller: Wolf not eat the ball!!!");
    }
    public void show(int variant) {
        switch (variant) {
            case 1:
                System.out.println("Wolf: Hello! I’ m a Wolf. And who are you?");
                break;
            case 2:
                System.out.println("Wolf: Good! I will eat you!");
                break;
            default:
                break;
        }
    }
}
