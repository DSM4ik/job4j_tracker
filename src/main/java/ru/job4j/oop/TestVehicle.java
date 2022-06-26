package ru.job4j.oop;

public class TestVehicle {
    public static void main(String[] args) {
        Vehicle airplane = new Airplane();
        Vehicle bus = new Bus();
        Vehicle train = new Train();

        Vehicle[] vh = new Vehicle[]{airplane, bus, train};

        for (Vehicle v : vh) {
            v.move();
        }
    }
}
