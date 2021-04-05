package ru.job4j.oop;

import org.junit.Test;

import static org.hamcrest.Matchers.closeTo;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PointTest {

    @Test
    public void distance_2() {
        Point a = new Point(0, 0);
        Point b = new Point(0, 2);
        double rslt = a.distance(b);
        assertThat(rslt, is(2.0));

    }

    @Test
    public void distance_3() {
        Point a = new Point(3, 0);
        Point b = new Point(0, 0);
        double rslt = a.distance(b);
        assertThat(rslt, is(3.0));

    }

    @Test
    public void distance3d_3() {
        Point a = new Point(0, 0, 0);
        Point b = new Point(3, 0, 0);
        double rslt = a.distance3d(b);
        assertThat(rslt, closeTo(3, 0));
    }

    @Test
    public void distance3d_4() {
        Point a = new Point(0, 4, 0);
        Point b = new Point(0, 0, 0);
        double rslt = a.distance3d(b);
        assertThat(rslt, closeTo(4, 0));
    }
}