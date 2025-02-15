package main;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

/**
 * Configuration class for Quito's vehicle restriction rules.
 * @author Jahir Rocha
 * @version 1.0
 */
public class QuitoRestrictionConfig implements RestrictionConfig {

    /**
     * Gets the time restrictions for Quito.
     * @return a list of time restrictions
     */
    @Override
    public List<TimeRestriction> getTimeRestrictions() {
        return Arrays.asList(
                new TimeRestriction(LocalTime.of(6, 0), LocalTime.of(9, 30)),
                new TimeRestriction(LocalTime.of(16, 0), LocalTime.of(20, 0))
        );
    }

    /**
     * Gets the day restrictions for Quito.
     * @return a list of day restrictions
     */
    @Override
    public List<DayRestriction> getDayRestrictions() {
        return Arrays.asList(
                new DayRestriction(DayOfWeek.MONDAY, 1, 2),
                new DayRestriction(DayOfWeek.TUESDAY, 3, 4),
                new DayRestriction(DayOfWeek.WEDNESDAY, 5, 6),
                new DayRestriction(DayOfWeek.THURSDAY, 7, 8),
                new DayRestriction(DayOfWeek.FRIDAY, 9, 0)
        );
    }
}