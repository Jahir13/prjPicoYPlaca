package main;

public class ANT {
    public static Vehicle vehicleRegistration(String plate) {
        if (plate == null || plate.trim().isEmpty()) {
            throw new IllegalArgumentException("Plate cannot be null or empty");
        }

        plate = plate.toUpperCase();

        if (plate.matches("^[A-Z]{3}-\\d{4}$")) {
            return new Car(plate);
        } else if (plate.matches("^[A-Z]{2}-\\d{3}[A-Z]$")) {
            return new Motorcycle(plate);
        }

        throw new IllegalArgumentException("Invalid plate format");
    }
}
