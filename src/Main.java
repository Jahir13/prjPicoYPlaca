import main.*;

/**
 * Main class to demonstrate the functionality of the Pico y Placa predictor.
 * This class initializes the necessary components and runs test cases to check
 * if vehicles can drive based on their license plates, dates, and times.
 *
 * @author Jahir Rocha
 * @version 1.0
 */
public class Main {

    public static void main(String[] args) {
        PlateValidatorInterface plateValidator = new PlateValidator();
        RestrictionConfig restrictionConfig = new QuitoRestrictionConfig();
        PicoPlacaPredictor predictor = new PicoPlacaPredictor(plateValidator, restrictionConfig);

        // Test case for a car
        System.out.println("=== Testing Car plate with 3 digits ===");
        testVehicle(predictor, "PBX-124", "2025-02-18", "08:30", "Car");

        System.out.println("=== Testing Car plate with 4 digits ===");
        testVehicle(predictor, "PBX-1230", "2025-02-18", "08:30", "Car");

        // Test case for a motorcycle
        System.out.println("\n=== Testing Motorcycle ===");
        testVehicle(predictor, "PB-128A", "2025-02-13", "17:30", "Motorcycle");
    }

    /**
     * Tests if a vehicle can drive on a specific date and time.
     * @param predictor the PicoPlacaPredictor instance to use
     * @param plate the license plate of the vehicle
     * @param date the date to check
     * @param time the time to check
     * @param testCase the name of the test case
     */
    private static void testVehicle(PicoPlacaPredictor predictor, String plate, String date, String time, String testCase) {
        try {
            boolean canDrive = predictor.canDrive(plate, date, time);
            System.out.printf("Test Case: %s%n", testCase);
            System.out.printf("Plate: %s, Date: %s, Time: %s%n", plate, date, time);
            System.out.printf("Can be on the road: %s%n", canDrive ? "Yes" : "No");
            System.out.println("-------------------");
        } catch (IllegalArgumentException e) {
            System.out.printf("Test Case: %s%n", testCase);
            System.out.printf("Error testing plate %s: %s%n", plate, e.getMessage());
            System.out.println("-------------------");
        }
    }
}
