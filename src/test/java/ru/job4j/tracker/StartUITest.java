package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;

public class StartUITest {

    @Test
    public void whenCreateItem() {
        Input in = new StubInput(new String[] {"0", "Item name", "1"});
        Tracker tracker = new Tracker();
        List<UserAction> actions = new ArrayList<UserAction>();
        actions.add(new CreateAction(new ConsoleOutput()));
        actions.add(new ExitAction(new ConsoleOutput()));
        new StartUI(new ConsoleOutput()).init(in, tracker, actions);
        assertThat(tracker.findAll().get(0).getName(), is("Item name"));
    }

    @Test
    public void whenReplaceItem2() {
        Tracker tracker = new Tracker();
        /* Добавим в tracker новую заявку */
        Item item = tracker.add(new Item("Replaced Item"));
        /* Входные данные должны содержать ID добавленной заявки item.getId() */
        String replacedName = "New Item name";
        Input in = new StubInput(
                                 new String[] {"0", String.valueOf(item.getId()), replacedName, "1"}
                                 );
        List<UserAction> actions = new ArrayList<UserAction>();
        actions.add(new ReplaceAction(new ConsoleOutput()));
        actions.add(new ExitAction(new ConsoleOutput()));
        new StartUI(new ConsoleOutput()).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName(), is(replacedName));
    }

    @Test
    public void whenDeleteItem2() {
        Tracker tracker = new Tracker();
        /* Добавим в tracker новую заявку */
        Item item = tracker.add(new Item("Deleted item"));
        /* Входные данные должны содержать ID добавленной заявки item.getId() */
        Input in = new StubInput(
                new String[] {"0", String.valueOf(item.getId()), "1"}
        );
        List<UserAction> actions = new ArrayList<UserAction>();
        actions.add(new DeleteAction(new ConsoleOutput()));
        actions.add(new ExitAction(new ConsoleOutput()));
        new StartUI(new ConsoleOutput()).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()), is(nullValue()));
    }

    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0"}
        );
        Tracker tracker = new Tracker();
        List<UserAction> actions = new ArrayList<UserAction>();
        actions.add(new ExitAction(out));
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator()
                              + "0. Exit" + System.lineSeparator()
        ));
    }

    @Test
    public void whenShowAction() {
        Output out = new StubOutput();
        Input in = new StubInput(
                       new String[] {"0", "1"}
                       );
        Tracker tracker = new Tracker();
        Item item = new Item("Item 1");
        tracker.add(item);
        List<UserAction> actions = new ArrayList<UserAction>();
        actions.add(new ShowAction(out));
        actions.add(new ExitAction(out));
        new StartUI(out).init(in, tracker, actions);

        assertThat(out.toString(), is(
                            "Menu." + System.lineSeparator()
                                   + "0. Show all Items" + System.lineSeparator()
                                   + "1. Exit" + System.lineSeparator()
                                   + "=== Show all Items ====" + System.lineSeparator()
                                   + item + System.lineSeparator()
                                   + "Menu." + System.lineSeparator()
                                   + "0. Show all Items" + System.lineSeparator()
                                   + "1. Exit" + System.lineSeparator()
        ));
    }

    @Test
    public void findByNameAction() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = new Item("Test");
        tracker.add(item);
        Input in = new StubInput(
                new String[] {"0", item.getName(), "1"}
        );

        List<UserAction> actions = new ArrayList<UserAction>();
        actions.add(new FindByNameAction(out));
        actions.add(new ExitAction(out));
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator()
                      + "0. Find Item by Name" + System.lineSeparator()
                      + "1. Exit" + System.lineSeparator()
                      + "=== Find item by Name ====" + System.lineSeparator()
                      + item + System.lineSeparator()
                      + "Menu." + System.lineSeparator()
                      + "0. Find Item by Name" + System.lineSeparator()
                      + "1. Exit" + System.lineSeparator()

        ));

    }

    @Test
    public void findByIDAction() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = new Item("Test");
        tracker.add(item);
        Input in = new StubInput(
                new String[] {"0", String.valueOf(item.getId()), "1"}
        );

        List<UserAction> actions = new ArrayList<UserAction>();
        actions.add(new FindByIdAction(out));
        actions.add(new ExitAction(out));

        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator()
                       + "0. Find Item by id" + System.lineSeparator()
                       + "1. Exit" + System.lineSeparator()
                       + "=== Find item by id ====" + System.lineSeparator()
                       + item + System.lineSeparator()
                       + "Menu." + System.lineSeparator()
                       + "0. Find Item by id" + System.lineSeparator()
                       + "1. Exit" + System.lineSeparator()

        ));

    }

    @Test
    public void whenInvalidExit() {
        Output out = new StubOutput();
        Input in = new StubInput(new String[] {"1", "0"});
        Tracker tracker = new Tracker();
        ArrayList<UserAction> actions = new ArrayList<UserAction>();
        actions.add(new ExitAction(out));
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                "Menu." + ln
                        + "0. Exit" + ln
                        + "Wrong input, you can select: 0 .. 0" + ln
                        + "Menu." + ln
                        + "0. Exit" + ln
                )
        );
    }

}