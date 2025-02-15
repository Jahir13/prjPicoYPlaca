package main;

import java.time.LocalTime;

/**
 * Represents a time restriction with a start and end time.
 *
 * @author Jahir Rocha
 * @version 1.0
 */
public class TimeRestriction {
    private final LocalTime start;
    private final LocalTime end;

    /**
     * Constructs a TimeRestriction with a specific start and end time.
     * @param start the start time of the restriction
     * @param end the end time of the restriction
     */
    public TimeRestriction(LocalTime start, LocalTime end) {
        this.start = start;
        this.end = end;
    }

    /**
     * Checks if a given time is within the restriction period.
     * @param time the time to check
     * @return true if the time is within the restriction, false otherwise
     */
    public boolean isWithinRestriction(LocalTime time) {
        return !time.isBefore(start) && !time.isAfter(end);
    }
}
