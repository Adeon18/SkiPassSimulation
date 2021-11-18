package skipass;

import carddata.WeekType;
import carddata.LiftType;
import lombok.Getter;

import java.util.Date;

@Getter
public class LiftsSkiPass extends SkiPass{
    private int duration;

    public LiftsSkiPass(WeekType weekType, LiftType duration) {
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
