package ru.job4j.poly;

public class Bus implements Transport {
    @Override
    public void drive() {
        System.out.println("Lets drive");
    }

    @Override
    public void passengers(int countPassengers) {
        System.out.println("Transporting..." + countPassengers);
    }

    @Override
    public double refuel(double countFuel) {
        double unitPrice = 45.5;
        return countFuel * unitPrice;
    }
}
