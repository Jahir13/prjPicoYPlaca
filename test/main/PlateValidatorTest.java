package main;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PlateValidatorTest {
    private final PlateValidator validator = new PlateValidator();

    @Test
    void testValidCarPlate() {
        assertTrue(validator.isValidPlate("DBX-1234"));
    }

    @Test
    void testValidMotorcyclePlate() {
        assertTrue(validator.isValidPlate("PB-123A"));
    }

    @Test
    void testInvalidPlateFormat() {
        assertFalse(validator.isValidPlate("PBX-12"));
    }
}