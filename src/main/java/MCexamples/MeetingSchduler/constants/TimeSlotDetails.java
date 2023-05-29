package MCexamples.MeetingSchduler.constants;

/**
 * Created by abhishek.gupt on 27/12/17.
 */
public enum TimeSlotDetails {

    START("start"),
    END("end");

    private String detail;

    TimeSlotDetails(String detail) {
        this.detail = detail;
    }

    public String getDetail() {
        return detail;
    }
}
