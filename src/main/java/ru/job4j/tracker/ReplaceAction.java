package ru.job4j.tracker;

public class ReplaceAction implements UserAction {
    private final Output output;

    public ReplaceAction(Output out) {
        this.output = out;
    }

    @Override
    public String name() {
        return "Edit item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        output.println("=== Edit item ===");
        int id = input.askInt("Enter id: ");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        if (tracker.replace(id, item)) {
            output.println("Заявка изменена успешно.");
        } else {
            output.println("Оибка ззамены ззаявки");
        }
        return true;
    }
}
