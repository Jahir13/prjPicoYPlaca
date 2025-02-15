package main;

/**
 * Interface for validating vehicle license plates.
 *
 * @author Jahir Rocha
 * @version 1.0
 */
public interface PlateValidatorInterface {
    /**
     * Validates the format of a license plate.
     * @param plate the license plate to validate
     * @return true if the plate is valid, false otherwise
     */
    boolean isValidPlate(String plate);

    /**
     * Retrieves the last digit of a license plate.
     * @param plate the license plate
     * @return the last digit of the plate
     * @throws IllegalArgumentException if the plate format is invalid
     */
    int getLastDigit(String plate);
}
