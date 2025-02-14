package main;

import java.time.LocalTime;

public class TimeRestriction {
    private final LocalTime start;
    private final LocalTime end;

    public TimeRestriction(LocalTime start, LocalTime end) {
        this.start = start;
        this.end = end;
    }

    public boolean isWithinRestriction(LocalTime time) {
        return !time.isBefore(start) && !time.isAfter(end);
    }
}