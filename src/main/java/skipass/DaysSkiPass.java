package skipass;

import carddata.WeekType;
import carddata.DayType;

import java.util.Date;

public class DaysSkiPass extends SkiPass{
    private Date prev_date;

    DaysSkiPass(WeekType weekType, DayType duration) {
        this.weekType = weekType;
        this.duration = duration.getLength();
        this.activated = true;
        prev_date = new Date();
    }
    @Override
    // Use the SkiPass if the day is changed, decrement the duration
    public void use(){
        Date new_date = new Date();
        if (isValidWeekType(new_date)) {
            if (new_date.getDate() != prev_date.getDate()) {
                duration--;
                prev_date = new_date;
            }
        } else {
            duration = 0;
        }
    }
}
