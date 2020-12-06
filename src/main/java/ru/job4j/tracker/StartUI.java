package ru.job4j.tracker;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class StartUI {

    public void init(Input input, Tracker tracker) {
        boolean run = true;
        int select = -1;
        while (run) {
            this.showMenu();
            do  {
                select = Integer.valueOf(input.askStr("Select: "));
                if (select < 0 || select > 6) {
                    System.out.println("Error. Try again!\n");
                }
            } while (select < 0 || select > 6);
            if (select == 0) {
                System.out.println("=== Create a new Item ====");
                String name = input.askStr("Enter name: ");
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
                    System.out.println("List of items is empty!\n");
                }
            } else if (select == 2) {
                int id = Integer.valueOf(input.askStr("=== Please enter item ID ====\n"));
                if (tracker.findById(id) != null) {
                    Item item = new Item(0, input.askStr("=== Please enter item Name ====\n"));
                    if (tracker.replace(id, item)) {
                        System.out.println("Data edit completed!\n");
                    } else {
                        System.out.println("Error replace Item!\n");
                    }
                } else System.out.println("Id not found!\n");
            } else if (select == 3) {
                int id = Integer.valueOf(input.askStr("=== Please enter item ID to delete item ====\n"));
                if (tracker.findById(id) != null) {
                    if (tracker.delete(id)) {
                        System.out.println("Item deleted!\n");
                    } else System.out.println("Error delete Item!\n");
                } else System.out.println("Id not found!");
            } else if (select == 4) {
                int id = Integer.valueOf(input.askStr("=== Please enter the search id ====\n"));
                Item item = tracker.findById(id);
                if (item != null) {
                    System.out.println(item.toString());
                } else {
                    System.out.println("Item not found:\n");
                }
            } else if (select == 5) {
                String name = input.askStr("=== Please enter the search Item name ====\n");
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
                "\nMenu.\n" +
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
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);

    }
}





