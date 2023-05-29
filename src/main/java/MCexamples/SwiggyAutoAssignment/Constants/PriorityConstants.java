package MCexamples.SwiggyAutoAssignment.Constants;

/**
 * Created by abhishek.gupt on 26/05/18.
 */
public enum PriorityConstants {

    FIRST_MILE("First Mile")
    ,DE_WAITING_TIME("DE Waiting Time")
    ,ORDER_DELAY_TIME("Order Delay Time");

    private String value;

    PriorityConstants(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

