package ru.job4j.tracker;

import java.util.ArrayList;

public class FindByNameAction implements UserAction {
    private final Output out;

    public FindByNameAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find Item by Name";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Find item by Name ====");
        String itmFind = input.askStr("Enter name Item for find");
        ArrayList<Item> findItems = tracker.findByName(itmFind);
        if (findItems.size() == 0) {
            out.println("Can't find Item with name = " + itmFind);
        } else {
            for (Item itemF : findItems) {
                out.println(itemF);
            }
        }
        return true;
    }
}
