package carddata;


import lombok.Getter;

public enum DayType {
    DAYS1(1), DAYS2(2), DAYS5(5);
    @Getter
    private int length;

    DayType(int length) {
        this.length = length;
    }
}
