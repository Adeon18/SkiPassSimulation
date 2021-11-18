package skipass;

import carddata.LiftType;
import carddata.WeekType;

import java.util.Date;

public class SeasonSkiPass extends SkiPass{
    private int duration;

    public SeasonSkiPass(WeekType weekType, LiftType duration) {
        this.weekType = weekType;
        this.duration = duration.getLength();
        this.activated = true;
    }
    @Override
    // Use the card if you can -> returns true if you can and decrements the duration and false if you don't.
    public void use(){
        Date date = new Date();
        if (isValidWeekType(date)){
            duration--;
        } else {
            duration = 0;
        }
    }

    @Override
    public boolean checkIfUsable() {
        if (duration > 0){
            return true;
        }
        return false;
    }
}
