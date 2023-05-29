package MCothers.JobPortalVersionGaurav.constants;

/**
 * Created by gaurav.kum on 13/12/17.
 */
public enum UserDetails {
    NAME("name"),
    CATEGORY("cat"),
    COMPANY_NAME("company"),
    DESIGNATION("designation"),
    EXPERIENCE("exp"),
    SKILL("skill"),
    LOCATION("location");

    private String detail;

    UserDetails(String detail) {
        this.detail = detail;
    }

    public String getDetail() {
        return detail;
    }
}
