import main.*;

public class Main {
    public static void main(String[] args) {
        PlateValidator validator = new PlateValidator();
        RestrictionConfig config = new QuitoRestrictionConfig();
        PicoPlacaPredictor predictor = new PicoPlacaPredictor(validator, config);

        System.out.println("Can PBX-1234 drive on 2025-02-10 at 08:30? " +
                predictor.canDrive("PBX-1230", "2025-02-14", "08:30"));
    }
}