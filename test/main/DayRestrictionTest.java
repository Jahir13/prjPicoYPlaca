package main;

import org.junit.jupiter.api.Test;
import java.time.DayOfWeek;
import static org.junit.jupiter.api.Assertions.*;

public class DayRestrictionTest {
    @Test
    void testRestrictionApplies() {
        DayRestriction restriction = new DayRestriction(DayOfWeek.MONDAY, 1, 2);
        assertTrue(restriction.appliesTo(DayOfWeek.MONDAY, 1));
    }

    @Test
    void testNoRestrictionOnDifferentDay() {
        DayRestriction restriction = new DayRestriction(DayOfWeek.TUESDAY, 3, 4);
        assertFalse(restriction.appliesTo(DayOfWeek.MONDAY, 3));
    }
}