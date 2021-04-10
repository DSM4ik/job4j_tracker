package ru.job4j.tracker;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class StartUI {
    public static void main(String[] args) {

        Tracker tracker = new Tracker();
        Item item = new Item("Заявление 1");
        tracker.add(item);
        Item itemResult = tracker.findById(1);

        System.out.println(itemResult.getId() + " - " + itemResult.getName());

        /* Item item = new Item();
        LocalDateTime itemDateTime = item.getCreated();
        System.out.println(itemDateTime.format(
                           DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss")
                                              )
                           );*/

    }
}
