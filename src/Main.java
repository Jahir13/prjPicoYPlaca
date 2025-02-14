import main.PlateValidator;

public class Main {
    public static void main(String[] args) {
        PlateValidator validator = new PlateValidator();
        System.out.println("Is PBX-1234 valid? " + validator.isValidPlate("DBX-7891"));
        System.out.println("Is PB-123A valid? " + validator.isValidPlate("PB-123A"));
    }
}