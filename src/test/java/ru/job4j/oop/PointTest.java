package ru.job4j.oop;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.closeTo;
import static org.hamcrest.core.Is.is;


public class PointTest {

    @Test
    public void distanceIs2() {
        Point a = new Point(0, 0);
        Point b = new Point(0, 2);
        double rslt = a.distance(b);
        assertThat(rslt, is(2.0));

    }

    @Test
    public void distanceIs3() {
        Point a = new Point(3, 0);
        Point b = new Point(0, 0);
        double rslt = a.distance(b);
        assertThat(rslt, is(3.0));

    }

    @Test
    public void distance3dIs3() {
        Point a = new Point(0, 0, 0);
        Point b = new Point(3, 0, 0);
        double rslt = a.distance3d(b);
        assertThat(rslt, closeTo(3, 0));
    }

    @Test
    public void distance3dIs4() {
        Point a = new Point(0, 4, 0);
        Point b = new Point(0, 0, 0);
        double rslt = a.distance3d(b);
        assertThat(rslt, closeTo(4, 0));
    }
}