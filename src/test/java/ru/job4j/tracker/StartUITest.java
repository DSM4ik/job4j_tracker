package ru.job4j.tracker;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class StartUITest {

    @Test
    public void whenAddItem() {
        String[] answers = {"Fix PC"};
        Input input = new StubInput(answers);
        Tracker tracker = new Tracker();
        StartUI.createItem(input, tracker);
        Item created = tracker.findAll()[0];
        Item expected = new Item("Fix PC");
        Assert.assertEquals(created.getName(), expected.getName());
    }

    @Test
    public void whenEditItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("new item");
        tracker.add(item);
        String[] answers = {
                String.valueOf(item.getId()), /* id сохраненной заявки в объект tracker. */
                "edited item"
        };
        StartUI.editItem(new StubInput(answers), tracker);
        Item edited = tracker.findById(item.getId());
        Assert.assertEquals(edited.getName(), "edited item");
    }

    @Test
    public void whenDeleteItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("ItemNew");
        tracker.add(item);
        String[] answers = new String[] {"1"};
        StartUI.deleteItem(new StubInput(answers), tracker);
        Item deleted = tracker.findById(1);
        Assert.assertEquals(deleted, null);
    }
}