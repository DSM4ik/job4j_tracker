package ru.job4j.tracker;

public class FindByIdAction implements UserAction {
    @Override
    public String name() {
        return "Find Item by id";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== Find item by id ====");
        int idFind = input.askInt("Enter id Item for Find");
        Item itemFind = tracker.findById(idFind);
        //блок валидации, если Item с введенным id не был найден
        if (itemFind == null) {
            System.out.println("Can't find Item with id = " + idFind);
        } else {
            System.out.println(itemFind);
        }
        return true;
    }
}
