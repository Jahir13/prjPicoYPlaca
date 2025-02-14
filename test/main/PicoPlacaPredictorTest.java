package main;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PicoPlacaPredictorTest {
    private final PlateValidatorInterface validator = new PlateValidator();
    private final RestrictionConfig config = new QuitoRestrictionConfig();
    private final PicoPlacaPredictor predictor = new PicoPlacaPredictor(validator, config);

    @Test
    void testCarRestrictedOnMondayMorning() {
        assertFalse(predictor.canDrive("PBX-1231", "2025-02-10", "08:30"));
    }

    @Test
    void testCarAllowedOnSaturday() {
        assertTrue(predictor.canDrive("PBX-1231", "2025-02-15", "08:30"));
    }

    @Test
    void testCarBeforeRestrictionTime() {
        assertTrue(predictor.canDrive("PBX-1234", "2025-02-13", "05:59"));
    }

    @Test
    void testCarAfterRestrictionTime() {
        assertTrue(predictor.canDrive("PBX-1234", "2025-02-13", "15:30"));
    }

    @Test
    void testMotorcycleRestrictedOnThursdayMorning() {
        assertFalse(predictor.canDrive("PB-128A", "2025-02-13", "08:30"));
    }

    @Test
    void testMotorcycleAllowedOnSunday() {
        assertTrue(predictor.canDrive("PB-123A", "2025-02-16", "08:30"));
    }

    @Test
    void testMotorcycleInAfternoonRestriction() {
        assertFalse(predictor.canDrive("PB-128A", "2025-02-13", "16:30"));
    }

    @Test
    void testMotorcycleAfterAfternoonRestriction() {
        assertTrue(predictor.canDrive("PB-128A", "2025-02-13", "20:01"));
    }

    @Test
    void testInvalidProvinceCodeThrowsException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            predictor.canDrive("DXX-1234", "2025-02-13", "08:30");
        });

        assertEquals("Invalid province code", exception.getMessage());
    }

    @Test
    void testInvalidPlateFormatThrowsException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            predictor.canDrive("PBX-12345", "2025-02-13", "08:30");
        });

        assertEquals("Invalid plate format", exception.getMessage());
    }

    @Test
    void testInvalidDateFormatThrowsException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            predictor.canDrive("PBX-1234", "2025-02-", "08:30");
        });

        assertEquals("Invalid input format", exception.getMessage());
    }
}
