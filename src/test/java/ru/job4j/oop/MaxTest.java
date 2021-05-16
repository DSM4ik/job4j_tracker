package ru.job4j.oop;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.MatcherAssert.*;

public class MaxTest {

    @Test
    public void max2values() {
        int rsl = Max.max(2, 3);
        assertThat(rsl, is(3));

    }

    @Test
    public void max3values() {
        int rsl = Max.max(2, 3, 5);
        assertThat(rsl, is(5));
    }

    @Test
    public void max4values() {
        int rsl = Max.max(9, 7, 5, 8);
        assertThat(rsl, is(9));
    }
}