package main;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * Predicts whether a vehicle can drive based on Pico y Placa restrictions.
 *
 * @author Jahir Rocha
 * @version 1.0
 */
public class PicoPlacaPredictor {
    private final PlateValidatorInterface plateValidator;
    private final RestrictionConfig restrictionConfig;

    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm");

    /**
     * Constructs a PicoPlacaPredictor with a plate validator and restriction configuration.
     * @param plateValidator the plate validator to use
     * @param restrictionConfig the restriction configuration to use
     */
    public PicoPlacaPredictor(PlateValidatorInterface plateValidator, RestrictionConfig restrictionConfig) {
        this.plateValidator = plateValidator;
        this.restrictionConfig = restrictionConfig;
    }

    /**
     * Determines if a vehicle can drive on a specific date and time.
     * @param plate the license plate of the vehicle
     * @param date the date to check
     * @param time the time to check
     * @return true if the vehicle can drive, false otherwise
     * @throws IllegalArgumentException if the plate format or input format is invalid
     */
    public boolean canDrive(String plate, String date, String time) {
        try {
            if (!plateValidator.isValidPlate(plate)) {
                throw new IllegalArgumentException("Invalid plate format");
            }

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

        } catch (IllegalArgumentException e) {
            throw e;
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid input format", e);
        }
    }
}
