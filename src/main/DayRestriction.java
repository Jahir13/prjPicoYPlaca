package main;

import java.time.DayOfWeek;
import java.util.Arrays;
import java.util.List;

public class DayRestriction {
    private final DayOfWeek day;
    private final List<Integer> restrictedDigits;

    public DayRestriction(DayOfWeek day, Integer... restrictedDigits) {
        this.day = day;
        this.restrictedDigits = Arrays.asList(restrictedDigits);
    }

    public boolean appliesTo(DayOfWeek checkDay, int lastDigit) {
        return day == checkDay && restrictedDigits.contains(lastDigit);
    }
}