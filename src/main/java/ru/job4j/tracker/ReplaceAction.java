package ru.job4j.tracker;

public class ReplaceAction implements UserAction {
    @Override
    public String name() {
        return "Edit item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== Replace Item ===");
        int id = Integer.valueOf(input.askStr("=== Please enter item ID ===="));
        Item item = new Item(input.askStr("=== Please enter item Name ===="));
        if (tracker.replace(id, item)) {
            System.out.println("Data edit completed!");
        } else {
            System.out.println("Id not found!");
        }
        return true;
    }

}