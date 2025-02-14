package main;

import org.junit.jupiter.api.Test;
import java.time.LocalTime;
import static org.junit.jupiter.api.Assertions.*;

public class TimeRestrictionTest {
    @Test
    void testWithinMorningRestriction() {
        TimeRestriction restriction = new TimeRestriction(LocalTime.of(6, 0), LocalTime.of(9, 30));
        assertTrue(restriction.isWithinRestriction(LocalTime.of(8, 0)));
    }

    @Test
    void testOutsideMorningRestriction() {
        TimeRestriction restriction = new TimeRestriction(LocalTime.of(6, 0), LocalTime.of(9, 30));
        assertFalse(restriction.isWithinRestriction(LocalTime.of(10, 0)));
    }

    @Test
    void testWithinAfternoonRestriction() {
        TimeRestriction restriction = new TimeRestriction(LocalTime.of(16, 0), LocalTime.of(19, 30));
        assertTrue(restriction.isWithinRestriction(LocalTime.of(17, 0)));
    }

    @Test
    void testOutsideAfternoonRestriction() {
        TimeRestriction restriction = new TimeRestriction(LocalTime.of(16, 0), LocalTime.of(19, 30));
        assertFalse(restriction.isWithinRestriction(LocalTime.of(20, 0)));
    }
}
