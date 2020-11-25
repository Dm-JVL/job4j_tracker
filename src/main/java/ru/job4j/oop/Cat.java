package ru.job4j.oop;

public class Cat {
    public String nickName, eatFood;

    public void giveNick(String nick) {
        this.nickName = nick;
    }

    public void eat(String food) {
        this.eatFood = food;
    }

    public void show() {
        System.out.println("Nickname - " + this.nickName + "\nFood - " + this.eatFood + "\n");
    }

    public static void main(String[] args) {
        Cat gav = new Cat();
        gav.giveNick("gav");
        gav.eat("kotleta");
        gav.show();
        Cat black = new Cat();
        black.giveNick("black");
        black.eat("fish");
        black.show();
    }
}
