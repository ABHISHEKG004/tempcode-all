package MCexamples.ReceptionSystem.model;

/**
 * Created by abhishek.gupt on 16/02/18.
 */
public class Customer {

    private int cid;
    private String CustName;
    private String Address;
    private String query;
    private int startTimeStamp;
    private int endTimeStamp;

    public Customer(int cid, String custName, String address, String query) {
        this.cid = cid;
        CustName = custName;
        Address = address;
        this.query = query;
    }

    public int getCid() {
        return cid;
    }

    public String getCustName() {
        return CustName;
    }

    public String getAddress() {
        return Address;
    }

    public String getQuery() {
        return query;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public void setCustName(String custName) {
        CustName = custName;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public void setQuery(String query) {
        this.query = query;
    }
}
