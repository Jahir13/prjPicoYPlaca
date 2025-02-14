package main;

import java.util.regex.Pattern;

public class Car extends Vehicle {
    private static final Pattern PLATE_PATTERN = Pattern.compile("^[A-Z]{3}-\\d{4}$");

    public Car(String plate) {
        super(plate);
    }

    @Override
    public boolean isValidPlate() {
        return PLATE_PATTERN.matcher(plate).matches();
    }

    @Override
    public int getLastDigit() {
        return Integer.parseInt(plate.substring(plate.length() - 1));
    }
}
