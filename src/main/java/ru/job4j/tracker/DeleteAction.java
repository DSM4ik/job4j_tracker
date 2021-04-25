package ru.job4j.tracker;

public class DeleteAction implements UserAction {
    @Override
    public String name() {
        return "Delete Item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== Delete Item ====");
        int idDel = input.askInt("Enter id Item for delete");
        if (tracker.delete(idDel)) {
            System.out.println("Item delete succesfully");
        } else {
            System.out.println("Can't find Item with id = " + idDel);
        }
        return true;
    }
}
