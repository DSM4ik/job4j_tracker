package ru.job4j.tracker;

import java.util.ArrayList;

public class ShowAction implements UserAction {
    private final Output out;

    public ShowAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Show all Items";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Show all Items ====");
        ArrayList<Item> items = tracker.findAll();
        for (Item itm : items) {
            out.println(itm);
        }
        return true;
    }
}
