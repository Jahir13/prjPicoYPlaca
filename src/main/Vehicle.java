package main;

/**
 * Abstract class representing a generic vehicle.
 * @author Jahir Rocha
 * @version 1.0
 */
public abstract class Vehicle {
    protected String plate;

    /**
     * Constructor for Vehicle.
     * @param plate the license plate of the vehicle
     */
    public Vehicle(String plate) {
        this.plate = plate;
    }

    /**
     * Checks if the license plate is valid.
     * @return true if the plate is valid, false otherwise
     */
    public abstract boolean isValidPlate();

    /**
     * Gets the last digit of the license plate.
     * @return the last digit of the plate
     */
    public abstract int getLastDigit();
}