package ru.job4j.tracker;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class StartUI {
    public static void createItem(Input input, Tracker tracker) {
        System.out.println("=== Create a new Item ====");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        tracker.add(item);
        System.out.println("Application added!");
    }

    public static void outputItems(Input input, Tracker tracker) {
        System.out.println("=== Output all items ====");
        Item[] allItem = tracker.findAll();
        if (allItem.length > 0) {
            for (int i = 0; i < allItem.length; i++) {
                System.out.println(allItem[i].toString());
            }
            System.out.println("Data output is completed!");
        } else {
            System.out.println("List of items is empty!");
        }
    }

    public static void replaceItem(Input input, Tracker tracker) {
        int id = Integer.valueOf(input.askStr("=== Please enter item ID ===="));
        Item item = new Item(input.askStr("=== Please enter item Name ===="));
        if (tracker.replace(id, item)) {
            System.out.println("Data edit completed!");
        } else {
            System.out.println("Id not found!");
        }
   }

    public static void deleteItem(Input input, Tracker tracker) {
        int id = Integer.valueOf(input.askStr("=== Please enter item ID to delete item ===="));
     if (tracker.delete(id)) {
            System.out.println("Item deleted!");
        } else System.out.println("Id not found!");
   }

    public static void findItemId(Input input, Tracker tracker) {
        int id = Integer.valueOf(input.askStr("=== Please enter the search id ===="));
        Item item = tracker.findById(id);
        if (item != null) {
            System.out.println(item.toString());
        } else {
            System.out.println("Item not found:");
        }
    }

    public static void findItemName(Input input, Tracker tracker) {
        String name = input.askStr("=== Please enter the search Item name ====");
        Item[] rsl = tracker.findByName(name);
        if (rsl.length > 0) {
            for (int i = 0; i < rsl.length; i++) {
                System.out.println(rsl[i].toString());
            }
        } else {
            System.out.println("Item not found!");
        }
    }

    public void init(Input input, Tracker tracker) {
        boolean run = true;
        int select = -1;
        while (run) {
            this.showMenu();
            do {
                select = Integer.valueOf(input.askStr("Select: "));
                if (select < 0 || select > 6) {
                    System.out.println("Error. Try again!");
                }
            } while (select < 0 || select > 6);
            if (select == 0) {
                StartUI.createItem(input, tracker);
            } else if (select == 1) {
                StartUI.outputItems(input, tracker);
            } else if (select == 2) {
                StartUI.replaceItem(input, tracker);
            } else if (select == 3) {
                StartUI.deleteItem(input, tracker);
            } else if (select == 4) {
                StartUI.findItemId(input, tracker);
            } else if (select == 5) {
                StartUI.findItemName(input, tracker);
            } else if (select == 6) {
                System.out.println("Program completed!"+System.lineSeparator()+"Good by!");
                run = false;
            }
        }
    }

    private void showMenu() {
        System.out.println(
                "Menu."+System.lineSeparator()+
                        "0. Add new Item"+System.lineSeparator()+
                        "1. Show all items"+System.lineSeparator()+
                        "2. Edit item"+System.lineSeparator()+
                        "3. Delete item"+System.lineSeparator()+
                        "4. Find item by Id"+System.lineSeparator()+
                        "5. Find items by name"+System.lineSeparator()+
                        "6. Exit Program"+System.lineSeparator()
        );
    }


    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);

    }
}





