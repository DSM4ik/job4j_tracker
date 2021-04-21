package ru.job4j.tracker;

public class StartUI {
    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            int select = Integer.valueOf(input.askStr("Select"));
            switch (select) {
                case 0:
                    System.out.println("=== Create a new Item ====");
                    String name = input.askStr("Enter name: ");
                    Item item = new Item(name);
                    tracker.add(item);
                    break;
                case 1:
                    System.out.println("=== Show all Items ====");
                    Item[] items = tracker.findAll();
                    for (Item itm:items) {
                        System.out.println(itm);
                    }
                    break;
                case 2:
                    System.out.println("=== Edit Item ====");
                    int idItem = Integer.valueOf(input.askStr("Enter id item"));
                    String newItemName = input.askStr("Enter new name Item");
                    Item itm = new Item(newItemName);
                    //блок валидации, если Item с введенным id не был найден
                    if (tracker.replace(idItem, itm)) {
                        System.out.println("Name Changes succesfully");
                    } else {
                        System.out.println("Can't find Item with id = " + idItem);
                    }
                    break;
                case 3:
                    System.out.println("=== Delete Item ====");
                    int idDel = Integer.valueOf(input.askStr("Enter id Item for delete"));
                    if (tracker.delete(idDel)) {
                        System.out.println("Item delete succesfully");
                    } else {
                        System.out.println("Can't find Item with id = " + idDel);
                    }
                    break;
                case 4:
                    System.out.println("=== Find item by id ====");
                    int idFind = Integer.valueOf(input.askStr("Enter id Item for Find"));
                    Item itemFind = tracker.findById(idFind);
                    //блок валидации, если Item с введенным id не был найден
                    if (itemFind == null) {
                        System.out.println("Can't find Item with id = " + idFind);
                    } else {
                        System.out.println(itemFind);
                    }
                    break;
                case 5:
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
                    break;
                case 6:
                    run = false;
                    break;
                default:
                    System.out.println("Please input correctly paragraph");
            }
            /* if */
        }
    }

    private void showMenu() {
        System.out.println("Menu.");
        System.out.println("0. Add new Item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by Id");
        System.out.println("5. Find items by name");
        System.out.println("6.Exit Program");
        /* добавить остальные пункты меню. */
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }
}
