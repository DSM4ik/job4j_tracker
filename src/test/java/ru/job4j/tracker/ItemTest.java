package ru.job4j.tracker;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ItemTest {

    @Test
    public void sortByAsc() {
        List<Item> items = Arrays.asList(new Item(4, "item4"),
                                         new Item(3, "item3"),
                                         new Item(5, "item5"),
                                         new Item(2, "Item2"),
                                         new Item(1, "Item1")
                                        );
        Collections.sort(items, new SortItemByAsc());
        List<Item> itemsExpected = Arrays.asList(new Item(1, "Item1"),
                                                new Item(2, "Item2"),
                                                new Item(3, "item3"),
                                                new Item(4, "item4"),
                                                new Item(5, "item5")
                                                );
        assertThat(itemsExpected, is(items));
    }

    @Test
    public void sortByDesc() {
        List<Item> items = Arrays.asList(new Item(4, "item4"),
                                        new Item(3, "item3"),
                                        new Item(5, "item5"),
                                        new Item(2, "Item2"),
                                        new Item(1, "Item1")
        );

        List<Item> itemsExpected = Arrays.asList(new Item(5, "item5"),
                                                new Item(4, "item4"),
                                                new Item(3, "item3"),
                                                new Item(2, "Item2"),
                                                new Item(1, "Item1")
        );

        Collections.sort(items, new SortItemByDesc());
        assertThat(itemsExpected, is(items));
    }
}