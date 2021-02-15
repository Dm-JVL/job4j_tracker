package ru.job4j.tracker;

public class ValidateInput extends ConsoleInput {
    private final Output out;

    public ValidateInput(Output out) {
        super(out);
        this.out = out;
    }

    @Override
    public int askInt(String question) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = super.askInt(question);
                invalid = false;
            } catch (NumberFormatException nfe) {
                out.println("Please enter validate data again.");
            }
        } while (invalid);
        return value;
    }
}
