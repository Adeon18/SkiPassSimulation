import carddata.WeekType;
import carddata.DayType;
import carddata.LiftType;
import skipass.DaysSkiPass;
import skipass.LiftsSkiPass;
import skipass.SkiPass;
import turnstile.Turnstile;

public class Main {
    public static void main(String[] args) {
        SkiPass b = new DaysSkiPass(WeekType.WEEKEND, DayType.DAYS1);
        Turnstile t = new Turnstile();

        LiftsSkiPass c = new LiftsSkiPass(WeekType.WEEKEND, LiftType.LIFTS10);
        System.out.println(t.scanSkiPass(c));
        System.out.println(t.scanSkiPass(c));
        System.out.println(t.scanSkiPass(c));
        System.out.println(t.scanSkiPass(c));
        System.out.println(t.scanSkiPass(c));
        System.out.println(t.scanSkiPass(c));
        System.out.println(t.scanSkiPass(c));
        System.out.println(t.scanSkiPass(c));
        System.out.println(t.scanSkiPass(c));
        System.out.println(t.scanSkiPass(c));
        System.out.println(t.scanSkiPass(c));
        System.out.println(t.scanSkiPass(c));


    }
}
