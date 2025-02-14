package main;

import java.util.regex.Pattern;

public class Motorcycle extends Vehicle {
    private static final Pattern PLATE_PATTERN = Pattern.compile("^[A-Z]{2}-\\d{3}[A-Z]$");

    public Motorcycle(String plate) {
        super(plate);
    }

    @Override
    public boolean isValidPlate() {
        return PLATE_PATTERN.matcher(plate).matches();
    }

    @Override
    public int getLastDigit() {
        String[] parts = plate.split("-");
        return Character.getNumericValue(parts[1].charAt(2));
    }

    @Override
    public String getPlate() {
        return plate;
    }
}