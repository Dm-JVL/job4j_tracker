package ru.job4j.tracker;

public class ReplaceAction implements UserAction {
    private final Output out;

    public ReplaceAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Edit item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        boolean run = true;
        out.println("=== Replace Item ===");
        try {
            int id = Integer.valueOf(input.askStr("=== Please enter item ID ===="));
            Item item = new Item(input.askStr("=== Please enter item Name ===="));
            if (!tracker.replace(id, item)) {
                out.println("Id not found! Please enter correct id again.");
            } else {
                out.println("Data edit completed!");
            }
        } catch (NumberFormatException nfe) {
            out.println("Please enter validate id again.");
        }
        return true;
    }
}