package ru.job4j.tracker;

public class FindAllAction implements UserAction {
    private final Output out;

    public FindAllAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Show all items";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== Output Items ===");
        Item[] allItem = tracker.findAll();
        if (allItem.length > 0) {
            for (int i = 0; i < allItem.length; i++) {
                System.out.println(allItem[i].toString());
            }
            System.out.println("Data output is completed!");
        } else {
            System.out.println("List of items is empty!");
        }
        return true;
    }
}
