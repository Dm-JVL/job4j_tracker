package ru.job4j.tracker;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class StartUI {

    public void init(Tracker tracker) {
        Scanner scanner = new Scanner(System.in);
        String buf;
        boolean exitTrue = false;
        int select = -1;
        do {
            this.showMenu();
            buf = scanner.nextLine();
            if (this.isNumber(buf) && (Integer.valueOf(buf) >= 0 && Integer.valueOf(buf) <= 6)){
                select = Integer.valueOf(buf);
                exitTrue = this.selectSwitch(select, scanner, tracker);
            } else{
                System.out.println("Error - not correct number!\n Please try again!\n");
            }
        } while (!exitTrue);

    }

    public int enterId(Scanner scan, Tracker track) {
        int id = 0;
        boolean editComp = false;
        do {
            String bufId = scan.nextLine();
            if (this.isNumber(bufId)) {
                id = Integer.valueOf(bufId);
                if (track.findById(id) != null) {
                    return id;
                } else {
                    System.out.println("Error! Id not found!\n");
                    return -1;
                }
            } else {
                System.out.println("Error! Please try again!\n");
            }
        } while (true);

    }

    public boolean selectSwitch(int select, Scanner scan, Tracker track) {
        String name, buf, ItemName;
        int newId;
        boolean result = false;
        Item item;
        switch (select) {
            case 0: {
                System.out.println("=== Create a new Item ====\n");
                System.out.println("Enter name: \n");
                name = scan.nextLine();
                item = new Item(0, name);
                track.add(item);
                System.out.println("Application added!\n");
                break;
            }
            case 1: {
                System.out.println("=== Output all items ====\n");
                track.showAll(track.findAll());
                System.out.println("Data output is completed!\n");
                break;
            }
            case 2: {
                System.out.println("=== Please enter item ID ====\n");
                newId = enterId(scan, track);
                System.out.println("=== Please enter item Name ====\n");
                ItemName = scan.nextLine();
                item = new Item(0, ItemName);
                if (track.replace(newId, item)) {
                    System.out.println("Data edit completed!\n");
                } else {
                    System.out.println("Error replace Item!\n");
                }
                break;
            }
            case 3: {
                System.out.println("=== Please enter item ID to delete ====\n");
                newId = enterId(scan, track);
                if (track.delete(newId)) {
                    System.out.println("Item deleted!\n");
                } else {
                    System.out.println("Error delete Item!\n");
                }

                break;
            }
            case 4: {
                System.out.println("=== Please enter the search id ====\n");
                newId = enterId(scan, track);
                if (newId == -1) {
                } else {
                    System.out.println("Item found:\n");
                    System.out.println(track.findById(newId).toString());
                }
                break;
            }
            case 5: {
                System.out.println("=== Please enter the search Item name ====\n");
                name = scan.nextLine();
                Item[] rsl = track.findByName(name);
                if (rsl != null) {
                    track.showAll(rsl);
                } else {
                    System.out.println("Applications with this name were not found!\n");
                }
                break;
            }
            case 6: {
                System.out.println("Program completed!\nGood by!");
                result = true;
                break;
            }
            default: {
                System.out.println("Error! Please try again!\n");
                break;
            }
        }
        return result;
    }

    public boolean isNumber(String s) {
        try {
            int i = Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
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
                        "6. Exit Program\n" +
                        "Select:\n"
        );
    }


    public static void main(String[] args) {
        Tracker tracker = new Tracker();
        new StartUI().init(tracker);
    }
}




    /*public static void main(String[] args) {
        /*Tracker tracker = new Tracker();
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


