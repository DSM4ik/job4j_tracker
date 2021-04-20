package ru.job4j.oop;

public class TestVehicle {
    public static void main(String[] args) {
        Vehicle airplane = new Airplane();
        Vehicle train = new Train();
        Vehicle bus = new Bus();
        Vehicle[] vh = new Vehicle[] {airplane, train, bus};
        for (Vehicle v:vh) {
            v.move();
        }
    }
}
