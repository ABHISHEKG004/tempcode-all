package MCexamples.pendencysystem.models;

public enum PaymentTag {

    UPI("UPI"),
    WALLET("WALLET");

    public final String tag_string;

    PaymentTag(String tag_string) {
        this.tag_string = tag_string;
    }
}
