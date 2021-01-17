package ru.job4j.tracker;

public class DeleteAction  implements UserAction {
    @Override
    public String name() {
        return "Delete item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== Output Items ===");
        int id = Integer.valueOf(input.askStr("=== Please enter item ID to delete item ===="));
        if (tracker.delete(id)) {
            System.out.println("Item deleted!");
        } else System.out.println("Id not found!");
        return true;
    }
}

