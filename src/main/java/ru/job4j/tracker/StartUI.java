package ru.job4j.tracker;

public class StartUI {
    private final Output out;

    public StartUI(Output out) {
        this.out = out;
    }

    public static void createItem(Input input, Tracker tracker) {
        System.out.println("=== Create a new Item ====");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        tracker.add(item);
    }

    public static void showAllItems(Input input, Tracker tracker) {
        System.out.println("=== Show all Items ====");
        Item[] items = tracker.findAll();
        for (Item itm : items) {
            System.out.println(itm);
        }
    }

    public static void replaceItem(Input input, Tracker tracker) {
        System.out.println("=== Edit Item ====");
        int idItem = input.askInt("Enter id item");
        String newItemName = input.askStr("Enter new name Item");
        Item itm = new Item(newItemName);
        //блок валидации, если Item с введенным id не был найден
        if (tracker.replace(idItem, itm)) {
            System.out.println("Name Changes succesfully");
        } else {
            System.out.println("Can't find Item with id = " + idItem);
        }
    }

    public static void deleteItem(Input input, Tracker tracker) {
        System.out.println("=== Delete Item ====");
        int idDel = input.askInt("Enter id Item for delete");
        if (tracker.delete(idDel)) {
            System.out.println("Item delete succesfully");
        } else {
            System.out.println("Can't find Item with id = " + idDel);
        }
    }

    public static void findItemById(Input input, Tracker tracker) {
        System.out.println("=== Find item by id ====");
        int idFind = input.askInt("Enter id Item for Find");
        Item itemFind = tracker.findById(idFind);
        //блок валидации, если Item с введенным id не был найден
        if (itemFind == null) {
            System.out.println("Can't find Item with id = " + idFind);
        } else {
            System.out.println(itemFind);
        }
    }

    public static void findItemByName(Input input, Tracker tracker) {
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
    }

    public void init(Input input, Tracker tracker, UserAction[] actions) {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = input.askInt("Select ");
            UserAction action = actions[select];
            run = action.execute(input, tracker);
        }
    }

    private void showMenu(UserAction[] actions) {
        out.println("Menu.");
        for (int index = 0; index < actions.length; index++) {
            out.println(index + ". " + actions[index].name());
        }
    }

    public static void main(String[] args) {
        Output output = new ConsoleOutput();
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        UserAction[] actions = {new CreateAction(output),
                                new ShowAction(output),
                                new ReplaceAction(output),
                                new DeleteAction(output),
                                new FindByIdAction(output),
                                new FindByNameAction(output),
                                new ExitAction()};
        new StartUI(output).init(input, tracker, actions);
    }
}
