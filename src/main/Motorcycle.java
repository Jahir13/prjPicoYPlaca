package main;

import java.util.regex.Pattern;

/**
 * Class representing a motorcycle.
 * @author Jahir Rocha
 * @version 1.0
 */
public class Motorcycle extends Vehicle {
    private static final Pattern PLATE_PATTERN = Pattern.compile("^[A-Z]{2}-\\d{3}[A-Z]$");

    /**
     * Constructor for Motorcycle.
     * @param plate the license plate of the motorcycle
     */
    public Motorcycle(String plate) {
        super(plate);
    }

    /**
     * Checks if the motorcycle's license plate is valid.
     * @return true if the plate is valid, false otherwise
     */
    @Override
    public boolean isValidPlate() {
        return PLATE_PATTERN.matcher(plate).matches();
    }

    /**
     * Gets the last digit of the motorcycle's license plate.
     * @return the last digit of the plate
     */
    @Override
    public int getLastDigit() {
        String[] parts = plate.split("-");
        return Character.getNumericValue(parts[1].charAt(2));
    }
}