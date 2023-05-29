package MCexamples.SwiggyAutoAssignment.Constants;

/**
 * Created by abhishek.gupt on 26/05/18.
 */
public enum OrderStatus {

    PLACED(0)
    , ACCEPTED(1)
    , IN_PROGRESS(2)
    , COMPLETED(3)
    , DISPATCHED(4)
    , CANCELLED(5)
    , REJECTED(6);

    private int value;

    OrderStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
