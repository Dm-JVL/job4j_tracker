package ru.job4j.tracker;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class StartUI {

    public void init(Scanner scanner, Tracker tracker) {
        boolean run = true;
        int select = -1;
        while (run) {
            this.showMenu();
            do  {
                System.out.println("Select: ");
                select = Integer.valueOf(scanner.nextLine());
                if (select < 0 || select > 6) {
                    System.out.println("Error. Try again!\n");
                }
            } while (select < 0 || select > 6);
            if (select == 0) {
                System.out.println("=== Create a new Item ====");
                System.out.println("Enter name: ");
                String name = scanner.nextLine();
                Item item = new Item(0, name);
                tracker.add(item);
                System.out.println("Application added!\n");
            } else if (select == 1) {
                System.out.println("=== Output all items ====\n");
                Item[] allItem = tracker.findAll();
                if (allItem.length > 0) {
                    for (int i = 0; i < allItem.length; i++) {
                        System.out.println(allItem[i].toString());
                    }
                    System.out.println("Data output is completed!\n");
                } else {
                    System.out.println("List of items is empty!");
                }
            } else if (select == 2) {
                System.out.println("=== Please enter item ID ====\n");
                int id = Integer.valueOf(scanner.nextLine());
                if (tracker.findById(id) != null) {
                    System.out.println("=== Please enter item Name ====\n");
                    Item item = new Item(0, scanner.nextLine());
                    if (tracker.replace(id, item)) {
                        System.out.println("Data edit completed!\n");
                    } else {
                        System.out.println("Error replace Item!\n");
                    }
                } else System.out.println("Id not found!");
            } else if (select == 3) {
                System.out.println("=== Please enter item ID to delete item ====\n");
                int id = Integer.valueOf(scanner.nextLine());
                if (tracker.findById(id) != null) {
                    if (tracker.delete(id)) {
                        System.out.println("Item deleted!\n");
                    } else System.out.println("Error delete Item!\n");
                } else System.out.println("Id not found!");
            } else if (select == 4) {
                System.out.println("=== Please enter the search id ====\n");
                int id = Integer.valueOf(scanner.nextLine());
                Item item = tracker.findById(id);
                if (item != null) {
                    System.out.println(item.toString());
                } else {
                    System.out.println("Item not found:\n");
                }
            } else if (select == 5) {
                System.out.println("=== Please enter the search Item name ====\n");
                String name = scanner.nextLine();
                Item[] rsl = tracker.findByName(name);
                if (rsl.length > 0) {
                    for (int i = 0; i < rsl.length; i++) {
                        System.out.println(rsl[i].toString());
                    }
                } else {
                    System.out.println("Item not found!\n");
                }
            } else if (select == 6) {
                System.out.println("Program completed!\nGood by!");
                run = false;
            }
        }
    }

    private void showMenu() {
        System.out.println(
                "Menu.\n" +
                        "0. Add new Item\n" +
                        "1. Show all items\n" +
                        "2. Edit item\n" +
                        "3. Delete item\n" +
                        "4. Find item by Id\n" +
                        "5. Find items by name\n" +
                        "6. Exit Program\n"
        );
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tracker tracker = new Tracker();
        new StartUI().init(scanner, tracker);

    }
}





