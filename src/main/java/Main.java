import carddata.Season;
import carddata.WeekType;
import carddata.DayType;
import carddata.LiftType;
import registersystem.RegisterSystem;
import skipass.DaysSkiPass;
import skipass.LiftsSkiPass;
import skipass.SkiPass;
import turnstile.Turnstile;

public class Main {
    public static void main(String[] args) {
        // Can only be 1!!!
        RegisterSystem registerSystem = RegisterSystem.getRegisterSystem();
        Turnstile turnstile = new Turnstile();

        registerSystem.generateSkiPass(WeekType.WEEKDAY, LiftType.LIFTS10);
        // Use the card 10 times
        for(int i = 0; i <= 10; i++){
            turnstile.scanSkiPass(registerSystem.getRegisteredPasses().get(0));
        }
        registerSystem.generateSkiPass(WeekType.WEEKEND, LiftType.LIFTS10);
        // If you run it on a weekday, it will scan once and then deny
        turnstile.scanSkiPass(registerSystem.getRegisteredPasses().get(1));
        turnstile.scanSkiPass(registerSystem.getRegisteredPasses().get(1));

        // Here the access is granted until the next day hits
        registerSystem.generateSkiPass(WeekType.WEEKDAY, DayType.DAYS1);
        for(int i = 0; i <= 10; i++){
            turnstile.scanSkiPass(registerSystem.getRegisteredPasses().get(2));
        }

        // Here the ticket will always work on Weekends until the season end, but then f you use it on weekdays, it gets declined
        registerSystem.generateSeasonSkiPass(Season.FALL);
        for(int i = 0; i <= 5; i++){
            turnstile.scanSkiPass(registerSystem.getRegisteredPasses().get(3));
        }

        System.out.println(registerSystem.getPassLogs());
    }
}
