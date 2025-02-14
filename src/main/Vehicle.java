package main;

public abstract class Vehicle {
    protected String plate;

    public Vehicle(String plate) {
        this.plate = plate;
    }

    public abstract boolean isValidPlate();
    public abstract int getLastDigit();
    public abstract String getPlate();
}