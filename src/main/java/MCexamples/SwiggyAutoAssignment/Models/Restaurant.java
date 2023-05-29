package MCexamples.SwiggyAutoAssignment.Models;

/**
 * Created by abhishek.gupt on 26/05/18.
 */
public class Restaurant {
    String rid;
    String name;
    String address;
    Location location;
    int contactNo;
    double rating;


    public Restaurant(String rid, String name, String address, Location location, int contactNo, double rating) {
        this.rid = rid;
        this.name = name;
        this.address = address;
        this.location = location;
        this.contactNo = contactNo;
        this.rating = rating;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getRid() {
        return rid;
    }

    public void setRid(String rid) {
        this.rid = rid;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }


    public int getContactNo() {
        return contactNo;
    }

    public double getRating() {
        return rating;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setContactNo(int contactNo) {
        this.contactNo = contactNo;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}
