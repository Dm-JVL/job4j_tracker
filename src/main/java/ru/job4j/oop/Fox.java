package ru.job4j.oop;

public class Fox {
    public void tryEat(Ball ball){
        System.out.println("Storyteller: Puff-the-Ball met a Fox.");
        ball.show(1);
        this.show(1);
        ball.show(2);
        this.show(2);
        ball.show(3);
        this.show(3);
        System.out.println("Storyteller: Then Fox eats Puff – the – Ball and runs away!!!");
    }
    public void show(int variant) {
        switch (variant) {
            case 1:
                System.out.println("Fox:  Hello! I’ m a Fox. I have a long tail. Who are you?");
                break;
            case 2:
                System.out.println("Fox: Good! I will eat you!");
                break;
            case 3:
                System.out.println("Fox: Come to me, Puff – the – Ball. I can’ t se you.");
                break;
            default:
                break;
        }
    }
}
