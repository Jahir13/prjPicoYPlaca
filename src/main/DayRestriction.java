package main;

import java.time.DayOfWeek;
import java.util.Arrays;
import java.util.List;

/**
 * Represents a restriction based on the day of the week and the last digit of the license plate.
 *
 * @author Jahir Rocha
 * @version 1.0
 */
public class DayRestriction {
    private final DayOfWeek day;
    private final List<Integer> restrictedDigits;

    /**
     * Constructs a DayRestriction with a specific day and restricted digits.
     * @param day the day of the week for the restriction
     * @param restrictedDigits the digits that are restricted on the specified day
     */
    public DayRestriction(DayOfWeek day, Integer... restrictedDigits) {
        this.day = day;
        this.restrictedDigits = Arrays.asList(restrictedDigits);
    }

    /**
     * Checks if the restriction applies to a specific day and last digit.
     * @param checkDay the day to check
     * @param lastDigit the last digit of the license plate
     * @return true if the restriction applies, false otherwise
     */
    public boolean appliesTo(DayOfWeek checkDay, int lastDigit) {
        return day == checkDay && restrictedDigits.contains(lastDigit);
    }
}
