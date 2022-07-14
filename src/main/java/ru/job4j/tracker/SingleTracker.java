package ru.job4j.tracker;

public final class SingleTracker {
    private static SingleTracker instance = null;
    private Tracker tracker = new Tracker();

    private SingleTracker() {
    }

    public static SingleTracker getInstance() {
        if (instance == null) {
            instance = new SingleTracker();
        }
        return instance;
    }

    public Item add(Item item) {
        return tracker.add(item);
    }

    public Item findById(int id) {
        return tracker.findById(id);
    }

    public static void main(String[] args) {
        SingleTracker singleTracker = SingleTracker.getInstance();
        singleTracker.add(new Item("fff"));
        Item tst = singleTracker.findById(1);
        System.out.println(tst);
    }
}
