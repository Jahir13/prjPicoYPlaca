package main;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class PicoPlacaPredictor {
    private final PlateValidatorInterface plateValidator;
    private final RestrictionConfig restrictionConfig;

    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm");

    public PicoPlacaPredictor(PlateValidatorInterface plateValidator, RestrictionConfig restrictionConfig) {
        this.plateValidator = plateValidator;
        this.restrictionConfig = restrictionConfig;
    }

    public boolean canDrive(String plate, String date, String time) {
        try {


            LocalDate checkDate = LocalDate.parse(date, DATE_FORMATTER);
            LocalTime checkTime = LocalTime.parse(time, TIME_FORMATTER);

            if (checkDate.getDayOfWeek() == DayOfWeek.SATURDAY ||
                    checkDate.getDayOfWeek() == DayOfWeek.SUNDAY) {
                return true;
            }

            int lastDigit = plateValidator.getLastDigit(plate);

            boolean isRestrictedDay = false;
            List<DayRestriction> dayRestrictions = restrictionConfig.getDayRestrictions();

            for (DayRestriction restriction : dayRestrictions) {
                if (restriction.appliesTo(checkDate.getDayOfWeek(), lastDigit)) {
                    isRestrictedDay = true;
                    break;
                }
            }

            if (!isRestrictedDay) {
                return true;
            }

            List<TimeRestriction> timeRestrictions = restrictionConfig.getTimeRestrictions();
            boolean isWithinRestrictedTime = false;

            for (TimeRestriction restriction : timeRestrictions) {
                if (restriction.isWithinRestriction(checkTime)) {
                    isWithinRestrictedTime = true;
                    break;
                }
            }

            return !isWithinRestrictedTime;

        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid input format", e);
        }
    }
}