package main;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PicoPlacaPredictorTest {
    private final PlateValidator validator = new PlateValidator();
    private final RestrictionConfig config = new QuitoRestrictionConfig();
    private final PicoPlacaPredictor predictor = new PicoPlacaPredictor(validator, config);

    @Test
    void testCarRestrictedOnMondayMorning() {
        assertFalse(predictor.canDrive("PBX-1231", "2025-02-10", "08:30")); // Lunes, placa termina en 1
    }

    @Test
    void testCarAllowedOnSaturday() {
        assertTrue(predictor.canDrive("PBX-1231", "2025-02-15", "08:30")); // Sábado, sin restricción
    }

    @Test
    void testCarBeforeRestrictionTime() {
        assertTrue(predictor.canDrive("PBX-1234", "2025-02-13", "05:59")); // Jueves, antes de la restricción
    }

    @Test
    void testInvalidPlateThrowsException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            predictor.canDrive("INVALID-PLATE", "2025-02-10", "08:30");
        });

        assertEquals("Invalid plate format", exception.getMessage());
    }
}