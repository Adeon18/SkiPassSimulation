package registersystem;

import carddata.DayType;
import carddata.LiftType;
import carddata.WeekType;
import skipass.DaysSkiPass;
import skipass.LiftsSkiPass;
import skipass.SkiPass;

import java.util.ArrayList;
import java.util.List;

public class RegisterSystem {

    private static RegisterSystem registerSystem;
    List<SkiPass> registeredPasses = new ArrayList<SkiPass>();
    List<String> passLogs = new ArrayList<String>();

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

    public void generateSkiPass(WeekType weekType, LiftType liftType){
        LiftsSkiPass skiPass =  new LiftsSkiPass(weekType, liftType);
        registeredPasses.add(skiPass);
    }

    public void logEvent(String log) {
        passLogs.add(log);
    }
    // Deactivate the pass
    public void blockSkiPass(SkiPass skiPass){
        skiPass.setActivated(false);
    }
}
