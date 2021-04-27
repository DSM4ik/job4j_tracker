package ru.job4j.tracker;

public class FindByIdAction implements UserAction {
    private final Output out;

    public FindByIdAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find Item by id";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Find item by id ====");
        int idFind = input.askInt("Enter id Item for Find");
        Item itemFind = tracker.findById(idFind);
        if (itemFind == null) {
            out.println("Can't find Item with id = " + idFind);
        } else {
            out.println(itemFind);
        }
        return true;
    }
}
