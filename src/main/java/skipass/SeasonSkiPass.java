package skipass;

import carddata.LiftType;
import carddata.Season;
import carddata.WeekType;

import java.util.Calendar;
import java.util.Date;

public class SeasonSkiPass extends SkiPass{
    private Season season;

    public SeasonSkiPass(Season season) {
        // Can only be on weekends
        this.weekType = WeekType.WEEKEND;
        // Only for 1 season
        this.duration = 1;
        this.activated = true;
        this.season = season;
    }
    @Override
    // Here we check if the season that we use the card in is correct, othervise we block the card
    public void use(){
        Date date = new Date();
        if (isValidWeekType(date)){
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            int month = calendar.get(Calendar.MONTH);
            if (((month >= 3 && month <= 5) && season == Season.SPRING) ||
                ((month >= 6 && month <= 8) && season == Season.SUMMER) ||
                ((month >= 9 && month <= 11) && season == Season.FALL) ||
                ((month == 12 || (month >= 1 && month <= 2)) && season == Season.WINTER)) {
                duration--;
            }
        } else {
            duration = 0;
        }
    }
}
