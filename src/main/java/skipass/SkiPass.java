package skipass;

import carddata.WeekType;
import idgenertor.IdGenerator;
import lombok.Getter;
import lombok.Setter;

import java.util.Calendar;
import java.util.Date;

@Getter @Setter
public abstract class SkiPass {
    private int id;
    protected WeekType weekType;
    protected boolean activated;
    protected int duration;
    // Our constructor is package private only
    SkiPass() {
        this.id = IdGenerator.generateId();
    }

    public abstract void use();

    // Check if we can still use the card(Basically only checks for weekends and weekdays)
    protected boolean isValidWeekType(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        int weekDay = calendar.get(Calendar.DAY_OF_WEEK);
        if (weekType == WeekType.WEEKDAY){
            return weekDay != Calendar.SATURDAY && weekDay != Calendar.SUNDAY;
        }
        else if (weekType == WeekType.WEEKEND) {
            return weekDay == Calendar.SATURDAY || weekDay == Calendar.SUNDAY;
        }
        return false;
    }
    // This function just returns the fact tat the duration still exists.
    public boolean checkIfUsable() {
        return duration > 0;
    }
}
