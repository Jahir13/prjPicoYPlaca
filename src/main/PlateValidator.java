package main;

import java.util.Arrays;
import java.util.List;

public class PlateValidator implements PlateValidatorInterface {
    private static final List<Character> VALID_PROVINCE_CODES = Arrays.asList('A', 'B', 'C', 'E', 'G', 'H', 'I', 'J',
            'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z');

    @Override
    public boolean isValidPlate(String plate) {
        if (plate == null || plate.trim().isEmpty()) {
            return false;
        }

        plate = plate.toUpperCase();

        char provinceCode = plate.charAt(0);

        try {
            if (!VALID_PROVINCE_CODES.contains(provinceCode)) {
                throw new IllegalArgumentException("Invalid province code");
            }
        } catch (IllegalArgumentException e) {
            throw e;
        }

        try {
            Vehicle vehicle = ANT.vehicleRegistration(plate);
            return vehicle.isValidPlate();
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    @Override
    public int getLastDigit(String plate) {
        if (!isValidPlate(plate)) {
            throw new IllegalArgumentException("Invalid plate format");
        }

        Vehicle vehicle = ANT.vehicleRegistration(plate);
        return vehicle.getLastDigit();
    }
}