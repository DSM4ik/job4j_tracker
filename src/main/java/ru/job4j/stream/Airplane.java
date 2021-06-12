package ru.job4j.stream;

/**
 * Шаблон строитель
 */

public class Airplane {
    private String model;
    private int countPassenger;
    private double maxWeight;
    private double maxHeight;
    private int maxSpeed;
    private int countPilots;
    private int countStewards;

    static class BuilderAirplane {
        private String model;
        private int countPassenger;
        private double maxWeight;
        private double maxHeight;
        private int maxSpeed;
        private int countPilots;
        private int countStewards;

        BuilderAirplane buildModel(String model) {
            this.model = model;
            return this;
        }

        BuilderAirplane buildPassenger(int countPassenger) {
            this.countPassenger = countPassenger;
            return this;
        }

        BuilderAirplane buildWeight(double maxWeight) {
            this.maxWeight = maxWeight;
            return this;
        }

        BuilderAirplane buildHeight(double maxHeight) {
            this.maxHeight = maxHeight;
            return this;
        }

        BuilderAirplane buildMaxSpeed(int maxSpeed) {
            this.maxSpeed = maxSpeed;
            return this;
        }

        BuilderAirplane buildCountPilots(int countPilots) {
            this.countPilots = countPilots;
            return this;
        }

        BuilderAirplane buildCountStewards(int countStewards) {
            this.countStewards = countStewards;
            return this;
        }

        Airplane build() {
            Airplane airplane = new Airplane();
            airplane.model = model;
            airplane.countPassenger = countPassenger;
            airplane.countPilots = countPilots;
            airplane.maxHeight = maxHeight;
            airplane.countStewards = countStewards;
            airplane.maxSpeed = maxSpeed;
            airplane.maxWeight = maxWeight;
            return  airplane;
        }
    }

    @Override
    public String toString() {
        return "Airplane{"
                + "model='" + model + '\''
                + ", countPassenger=" + countPassenger
                + ", maxWeight=" + maxWeight
                + ", maxHeight=" + maxHeight
                + ", maxSpeed=" + maxSpeed
                + ", countPilots=" + countPilots
                + ", countStewards=" + countStewards
                + '}';
    }

    public static void main(String[] args) {
        Airplane airplane = new BuilderAirplane().buildCountPilots(5)
                            .buildHeight(10000)
                            .buildModel("TU 144")
                            .buildMaxSpeed(1800)
                            .buildCountStewards(3)
                            .buildCountPilots(6)
                            .build();
        System.out.println(airplane);

    }
}
