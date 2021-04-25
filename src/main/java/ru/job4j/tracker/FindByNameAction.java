package ru.job4j.tracker;

public class FindByNameAction implements UserAction {
    @Override
    public String name() {
        return "Find Item by Name";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== Find item by Name ====");
        String itmFind = input.askStr("Enter name Item for find");
        Item[] findItems = tracker.findByName(itmFind);
        //блок валидации, если Item с введенным Name не был найден
        if (findItems.length == 0) {
            System.out.println("Can't find Item with name = " + itmFind);
        } else {
            for (Item itemF : findItems) {
                System.out.println(itemF);
            }
        }
        return true;
    }
}
