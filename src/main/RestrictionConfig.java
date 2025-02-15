package main;

import java.util.List;

/**
 * Interface for defining restriction configurations.
 * @author Jahir Rocha
 * @version 1.0
 */
public interface RestrictionConfig {
    /**
     * Gets the time restrictions.
     * @return a list of time restrictions
     */
    List<TimeRestriction> getTimeRestrictions();

    /**
     * Gets the day restrictions.
     * @return a list of day restrictions
     */
    List<DayRestriction> getDayRestrictions();
}