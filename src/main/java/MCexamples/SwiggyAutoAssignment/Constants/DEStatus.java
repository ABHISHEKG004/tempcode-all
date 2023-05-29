package MCexamples.SwiggyAutoAssignment.Constants;

/**
 * Created by abhishek.gupt on 26/05/18.
 */
public enum DEStatus {
    IDLE(0)
    , ACTIVE(1);

    private int value;

    DEStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
