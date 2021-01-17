package ru.job4j.tracker;

public class FindIByNameAction implements UserAction {
    @Override
    public String name() {
        return "Find items by name";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== Find Item by Name ===");
        String name = input.askStr("=== Please enter the search Item name ====");
        Item[] rsl = tracker.findByName(name);
        if (rsl.length > 0) {
            for (int i = 0; i < rsl.length; i++) {
                System.out.println(rsl[i].toString());
            }
        } else {
            System.out.println("Item not found!");
        }
        return true;
    }
}

