package main;

import java.util.List;

public interface RestrictionConfig {
    List<TimeRestriction> getTimeRestrictions();

    List<DayRestriction> getDayRestrictions();
}
