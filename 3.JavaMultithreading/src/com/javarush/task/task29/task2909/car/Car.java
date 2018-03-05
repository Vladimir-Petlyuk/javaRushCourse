package com.javarush.task.task29.task2909.car;

import java.util.Date;

public abstract class Car {
    double fuel;
    public double summerFuelConsumption;
    public double winterFuelConsumption;
    public double winterWarmingUp;

    private int type;

    private boolean driverAvailable;
    private int numberOfPassengers;

    protected Car(int type, int numberOfPassengers) {
        this.numberOfPassengers = numberOfPassengers;
        this.type = type;
    }

    public static Car create(int type, int numberOfPassengers) {
        if (type == 0)
            return new Truck(numberOfPassengers);
        else if (type == 1)
            return new Sedan(numberOfPassengers);
        else
            return new Cabriolet(numberOfPassengers);
    }

    public void fill(double numberOfLiters) throws Exception {

        if (numberOfLiters < 0) {
            throw new Exception();
        } else {
            fuel += numberOfLiters;
        }
    }

    public double getTripConsumption(Date date, int length, Date SummerStart, Date SummerEnd) {
        if (isSummer(date, SummerStart, SummerEnd))
            return getSummerConsumption(length);
        else return getWinterConsumption(length);
    }

    public int getNumberOfPassengersCanBeTransferred() {

        if(canPassengersBeTransferred())
            return numberOfPassengers;
        return 0;
    }

    public boolean isDriverAvailable() {
        return driverAvailable;
    }

    public void setDriverAvailable(boolean driverAvailable) {
        this.driverAvailable = driverAvailable;
    }

    public void startMoving() {
        if (numberOfPassengers > 0)
            fastenPassengersBelts();
        fastenDriverBelt();
    }

    public void fastenPassengersBelts() {
    }

    public void fastenDriverBelt() {
    }

    public abstract int getMaxSpeed();

    public boolean isSummer(Date date, Date summerStart, Date summerEnd) {
        return date.after(summerStart) && date.before(summerEnd);
    }

    public double getWinterConsumption(int length) {
        return length * winterFuelConsumption + winterWarmingUp;
    }

    public double getSummerConsumption(int length) {
        return length * summerFuelConsumption;
    }

    private boolean canPassengersBeTransferred() {
        return isDriverAvailable() && fuel > 0;
    }
}