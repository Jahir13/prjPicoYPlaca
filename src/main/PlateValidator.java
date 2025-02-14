package main;

public class PlateValidator implements PlateValidatorInterface {
    @Override
    public boolean isValidPlate(String plate) {
        if (plate == null || plate.trim().isEmpty()) {
            return false;
        }
        return new Car(plate).isValidPlate() || new Motorcycle(plate).isValidPlate();
    }

    @Override
    public int getLastDigit(String plate) {
        if (new Car(plate).isValidPlate()) {
            return new Car(plate).getLastDigit();
        } else if (new Motorcycle(plate).isValidPlate()) {
            return new Motorcycle(plate).getLastDigit();
        }
        throw new IllegalArgumentException("Invalid plate format");
    }
}
