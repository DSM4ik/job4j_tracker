package ru.job4j.tracker;

public class DeleteAction implements UserAction {
    private final Output out;

    public DeleteAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Delete Item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Delete Item ====");
        int idDel = input.askInt("Enter id Item for delete");
        if (tracker.delete(idDel)) {
            out.println("Item delete succesfully");
        } else {
            out.println("Can't find Item with id = " + idDel);
        }
        return true;
    }
}
