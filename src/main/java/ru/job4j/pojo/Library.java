package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book[] book = new Book[4];
        for (int i = 0; i < book.length; i++) {
            book[i] = new Book();
        }
        book[0].setName("Clean code");
        System.out.println("List1:");
        for (int i = 0; i < book.length; i++) {
            System.out.println("№" + i + ": " + book[i].toString());
        }
        Book temp = new Book();
        temp = book[0];
        book[0] = book[3];
        book[3] = temp;
        System.out.println("List2:");
        for (int i = 0; i < book.length; i++) {
            if ((book[i].getName() != null) && book[i].getName().equals("Clean code")) {
                System.out.println("№" + i + ": " + book[i].toString());
            }
        }

    }
}
