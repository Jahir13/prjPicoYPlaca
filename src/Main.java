import main.*;

import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {
        TimeRestriction morningRestriction = new TimeRestriction(LocalTime.of(6, 0), LocalTime.of(9, 30));
        System.out.println("Is 08:00 within morning restriction? " + morningRestriction.isWithinRestriction(LocalTime.of(8, 0))); // true
    }
}