package main;

public interface PlateValidatorInterface {
    boolean isValidPlate(String plate);
    int getLastDigit(String plate);
}
