package ru.job4j.poly;

public interface Transport {
    void drive();

    void passengers(int countPassengers);

    double refuel(double countFuel);
}
