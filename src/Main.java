import main.ANT;
import main.Vehicle;

public class Main {
    public static void main(String[] args) {
        Vehicle car = ANT.vehicleRegistration("PBX-1234");
        Vehicle motorcycle = ANT.vehicleRegistration("PB-123A");

        System.out.println("Car plate: " + car.getPlate());           // PBX-1234
        System.out.println("Motorcycle plate: " + motorcycle.getPlate()); // PB-123A
    }
}