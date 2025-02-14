import main.*;


public class Main {
    public static void main(String[] args) {
        RestrictionConfig config = new QuitoRestrictionConfig();
        System.out.println("Time restrictions: " + config.getTimeRestrictions());
        System.out.println("Days restrictions: " + config.getDayRestrictions());
    }
}