import main.*;

import java.time.DayOfWeek;

public class Main {
    public static void main(String[] args) {
        DayRestriction mondayRestriction = new DayRestriction(DayOfWeek.MONDAY, 1, 2);
        System.out.println("Does Monday restriction apply to 1? " + mondayRestriction.appliesTo(DayOfWeek.MONDAY, 1));
    }
}