package ru.job4j.tracker;

public class ReplaceAction implements  UserAction {
    private final Output out;

    public ReplaceAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Edit Item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Edit Item ====");
        int idItem = input.askInt("Enter id item");
        String newItemName = input.askStr("Enter new name Item");
        Item itm = new Item(newItemName);
        //блок валидации, если Item с введенным id не был найден
        if (tracker.replace(idItem, itm)) {
            out.println("Name Changes succesfully");
        } else {
            out.println("Can't find Item with id = " + idItem);
        }
        return true;
    }
}
