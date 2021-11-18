package carddata;

import lombok.Getter;

public enum LiftType {
    LIFTS10(10), LIFTS20(20), LIFTS50(50), LIFTS100(100);

    @Getter
    private int length;

    LiftType(int length) {
        this.length = length;
    }
}
