package ru.job4j.tracker;

public class DeleteAction  implements UserAction {
    private final Output out;

    public DeleteAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Delete item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
       out.println("=== Delete Items ===");
        int id = Integer.valueOf(input.askStr("=== Please enter item ID to delete item ===="));
        if (tracker.delete(id)) {
           out.println("Item deleted!");
        } else out.println("Id not found!");
        return true;
    }
}

