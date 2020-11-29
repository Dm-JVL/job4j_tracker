package ru.job4j.tracker;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class StartUI {
    public static void main(String[] args) {
        Tracker tracker = new Tracker();
        Item[] item = new Item[4];
        item[0] = new Item(1, "Name_1");
        item[1] = new Item(2, "Name_2");
        item[2] = new Item(3, "Name_3");
        item[3] = new Item(4, "Name_1");
        for (int i = 0; i < item.length; i++) {
            tracker.add(item[i]);
        }
        Item temp = tracker.findById(3);
        if (temp != null) {
            System.out.println(temp.toString());
        } else System.out.println("Id not found");


        /*LocalDateTime currentDateTime = item.getCreated();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
        String currentDateTimeFormat = currentDateTime.format(formatter);
        System.out.println("Текущие дата и время после форматирования: " + currentDateTimeFormat);
        System.out.println(item.toString());*/
    }
}
