import main.*;

public class Main {
    public static void main(String[] args) {
        PlateValidatorInterface plateValidator = new PlateValidator();
        RestrictionConfig restrictionConfig = new QuitoRestrictionConfig();
        PicoPlacaPredictor predictor = new PicoPlacaPredictor(plateValidator, restrictionConfig);

        System.out.println("=== Testing Car ===");
        testVehicle(predictor, "PBX-1234", "2025-02-13", "08:30", "Car");

        System.out.println("\n=== Testing Motorcycle ===");
        testVehicle(predictor, "PB-128A", "2025-02-13", "17:30", "Motorcycle");

    }

    private static void testVehicle(PicoPlacaPredictor predictor, String plate, String date, String time, String testCase) {
        try {
            boolean canDrive = predictor.canDrive(plate, date, time);
            System.out.printf("Test Case: %s%n", testCase);
            System.out.printf("Plate: %s, Date: %s, Time: %s%n", plate, date, time);
            System.out.printf("Can drive: %s%n", canDrive ? "Yes" : "No");
            System.out.println("-------------------");
        } catch (IllegalArgumentException e) {
            System.out.printf("Test Case: %s%n", testCase);
            System.out.printf("Error testing plate %s: %s%n", plate, e.getMessage());
            System.out.println("-------------------");
        }
    }
}