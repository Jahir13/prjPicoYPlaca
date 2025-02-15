package main;

import java.util.Arrays;
import java.util.List;

/**
 * Validates vehicle license plates according to Ecuadorian regulations.
 *
 * @author Jahir Rocha
 * @version 1.0
 */
public class PlateValidator implements PlateValidatorInterface {
    private static final List<Character> VALID_PROVINCE_CODES = Arrays.asList('A', 'B', 'C', 'E', 'G', 'H', 'I', 'J',
            'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z');

    /**
     * Validates the format of a license plate.
     * @param plate the license plate to validate
     * @return true if the plate is valid, false otherwise
     * @throws IllegalArgumentException if the plate is null, empty, or has an invalid province code
     */
    @Override
    public boolean isValidPlate(String plate) {
        if (plate == null || plate.trim().isEmpty()) {
            return false;
        }

        plate = plate.toUpperCase();

        char provinceCode = plate.charAt(0);

        if (!VALID_PROVINCE_CODES.contains(provinceCode)) {
            throw new IllegalArgumentException("Invalid province code");
        }

        try {
            Vehicle vehicle = ANT.vehicleRegistration(plate);
            return vehicle.isValidPlate();
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    /**
     * Retrieves the last digit of a license plate.
     * @param plate the license plate
     * @return the last digit of the plate
     * @throws IllegalArgumentException if the plate format is invalid
     */
    @Override
    public int getLastDigit(String plate) {
        if (!isValidPlate(plate)) {
            throw new IllegalArgumentException("Invalid plate format");
        }

        Vehicle vehicle = ANT.vehicleRegistration(plate);
        return vehicle.getLastDigit();
    }
}
