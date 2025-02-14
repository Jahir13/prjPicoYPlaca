package main;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PlateValidatorTest {
    private final PlateValidator validator = new PlateValidator();

    @Test
    void testValidMotorcyclePlate() {
        assertTrue(validator.isValidPlate("PB-123A"));
    }

    @Test
    void testInvalidPlateFormat() {
        assertFalse(validator.isValidPlate("PBX-12"));
    }

    @Test
    void testInvalidProvinceCodeThrowsException() {
        int lastDigit = validator.getLastDigit("AXX-1234");
        assertEquals(4, lastDigit);
    }

    @Test
    void testInvalidPlateThrowsException1() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            validator.isValidPlate("DBX-1234");
        });

        assertEquals("Invalid province code", exception.getMessage());
    }
}