package ru.job4j.oop;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class PointTest {

    @Test
    public void distanceIs2() {
        Point a = new Point(0, 0);
        Point b = new Point(0, 2);
        double rslt = a.distance(b);
        Assert.assertEquals(2.0, rslt, 0.0);
    }

    @Test
    public void distanceIs3() {
        Point a = new Point(3, 0);
        Point b = new Point(0, 0);
        double rslt = a.distance(b);
        Assert.assertEquals(3.0, rslt, 0.0);
    }

    @Test
    public void distance3dIs3() {
        Point a = new Point(0, 0, 0);
        Point b = new Point(3, 0, 0);
        double rslt = a.distance3d(b);
        Assert.assertEquals(3.0, rslt, 0.0);
    }
}