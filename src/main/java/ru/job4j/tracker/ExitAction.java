package ru.job4j.tracker;

public class ExitAction implements UserAction {
    private final Output output;

    public ExitAction(Output out) {
        this.output = out;
    }

    @Override
    public String name() {
        return "Exit Program";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        output.println("=== Exit Program ===");
        return false;
    }
}
