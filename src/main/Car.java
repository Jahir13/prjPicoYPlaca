package main;

import java.util.regex.Pattern;

/**
 * Class representing a car.
 */
public class Car extends Vehicle {
    private static final Pattern PLATE_PATTERN = Pattern.compile("^[A-Z]{3}-\\d{3,4}$");

    /**
     * Constructor for Car.
     * @param plate the license plate of the car
     */
    public Car(String plate) {
        super(plate);
    }

    /**
     * Checks if the car's license plate is valid.
     * @return true if the plate is valid, false otherwise
     */
    @Override
    public boolean isValidPlate() {
        return PLATE_PATTERN.matcher(plate).matches();
    }

    /**
     * Gets the last digit of the car's license plate.
     * @return the last digit of the plate
     */
    @Override
    public int getLastDigit() {
        return Integer.parseInt(plate.substring(plate.length() - 1));
    }
}