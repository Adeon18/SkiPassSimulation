package skipass;

import carddata.DayType;
import carddata.LiftType;
import carddata.Season;
import carddata.WeekType;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class RegisterSystem {

    private static RegisterSystem registerSystem;
    @Getter List<SkiPass> registeredPasses = new ArrayList<SkiPass>();
    @Getter List<String> passLogs = new ArrayList<String>();

    private RegisterSystem() {
    }
    // We can only have one registersystem.
    public static RegisterSystem getRegisterSystem(){
        if (registerSystem == null) {
            registerSystem = new RegisterSystem();
        }
        return registerSystem;
    }

    // Create The Skipass that is typed by days.
    public void generateSkiPass(WeekType weekType, DayType dayType){
        DaysSkiPass skiPass = new DaysSkiPass(weekType, dayType);
        registeredPasses.add(skiPass);
    }
    // By lifts
    public void generateSkiPass(WeekType weekType, LiftType liftType){
        LiftsSkiPass skiPass =  new LiftsSkiPass(weekType, liftType);
        registeredPasses.add(skiPass);
    }
    // This is pretty bad, I know but I couldn't think of a better system.
    // This is a separate function for season.
    public void generateSeasonSkiPass(Season season){
        SeasonSkiPass skiPass = new SeasonSkiPass(season);
        registeredPasses.add(skiPass);
    }
    // We keep the logs as an array of strings.
    public void logEvent(String log) {
        passLogs.add(log);
    }
    // Deactivate the pass
    public void blockSkiPass(SkiPass skiPass){
        skiPass.setActivated(false);
    }
}
