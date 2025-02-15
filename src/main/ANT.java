package main;

/**
 * Utility class for vehicle registration.
 * This class provides functionality to create vehicle instances based on
 * their license plate format according to Ecuadorian regulations.
 *
 * @author Jahir Rocha
 * @version 1.0
 */
public class ANT {
    /**
     * Registers a vehicle based on the license plate format.
     * @param plate the license plate of the vehicle
     * @return a Vehicle object (Car or Motorcycle)
     * @throws IllegalArgumentException if the plate is null, empty, or invalid
     */
    public static Vehicle vehicleRegistration(String plate) {
        if (plate == null || plate.trim().isEmpty()) {
            throw new IllegalArgumentException("Plate cannot be null or empty");
        }

        plate = plate.toUpperCase();

        if (plate.matches("^[A-Z]{3}-\\d{3,4}$")) {
            return new Car(plate);
        } else if (plate.matches("^[A-Z]{2}-\\d{3}[A-Z]$")) {
            return new Motorcycle(plate);
        }

        throw new IllegalArgumentException("Invalid plate format");
    }
}