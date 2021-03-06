package ru.job4j.tracker;

public class FindByIdAction implements UserAction {
    private final Output out;

    public FindByIdAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find item by Id";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
       out.println("=== Find Item by Id ===");
        int id = Integer.valueOf(input.askStr("=== Please enter the search id ===="));
        Item item = tracker.findById(id);
        if (item != null) {
            out.println(item.toString());
        } else {
            out.println("Item not found:");
        }
        return true;
    }
}



