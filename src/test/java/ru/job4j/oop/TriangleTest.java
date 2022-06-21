package ru.job4j.oop;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class TriangleTest {

    @Test
    public void when00and40and04Then8() {
        Point a = new Point(0, 0);
        Point b = new Point(4, 0);
        Point c = new Point(0, 4);
        Triangle triangle = new Triangle(a, b, c);
        double rsl = triangle.area();
        //assertThat(rsl, closeTo(8, 0.001));
        Assert.assertEquals(rsl, 8, 0.001);
    }

    @Test
    public void existTriangle() {
        Point a = new Point(0, 0);
        Point b = new Point(4, 0);
        Point c = new Point(0, 4);

        Triangle triangle = new Triangle(a, b, c);
        double ab = a.distance(b);
        double ac = a.distance(c);
        double bc = b.distance(c);
        Assert.assertTrue(triangle.exist(ab, ac, bc));
    }

    @Test
    public void semiperimeter682() {

        Point a = new Point(0, 0);
        Point b = new Point(4, 0);
        Point c = new Point(0, 4);

        Triangle triangle = new Triangle(a, b, c);
        double ab = a.distance(b);
        double ac = a.distance(c);
        double bc = b.distance(c);
        Assert.assertEquals(6.82, triangle.semiPerimeter(ab, ac, bc), 0.01);
    }

    @Test
    public void areaTriangle799() {

        Point a = new Point(0, 0);
        Point b = new Point(4, 0);
        Point c = new Point(0, 4);

        Triangle triangle = new Triangle(a, b, c);
        System.out.println(triangle.area());
        Assert.assertEquals(7.99, triangle.area(), 0.01);
    }

    @Test
    public void areaTriangleNOminus1() {

        Point a = new Point(0, 0);
        Point b = new Point(0, 0);
        Point c = new Point(0, 4);

        Triangle triangle = new Triangle(a, b, c);
        System.out.println(triangle.area());
        Assert.assertEquals(-1, triangle.area(), 0.1);
    }
}