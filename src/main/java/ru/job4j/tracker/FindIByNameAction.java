package ru.job4j.tracker;

public class FindIByNameAction implements UserAction {
    private final Output out;

    public FindIByNameAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find items by name";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
       out.println("=== Find Item by Name ===");
        String name = input.askStr("=== Please enter the search Item name ====");
        Item[] rsl = tracker.findByName(name);
        if (rsl.length > 0) {
            for (int i = 0; i < rsl.length; i++) {
                out.println(rsl[i].toString());
            }
        } else {
           out.println("Item not found!");
        }
        return true;
    }
}

