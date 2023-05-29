package MCexamples.SwiggyAutoAssignment.Models;

/**
 * Created by abhishek.gupt on 26/05/18.
 */
public class DeliveryExecutive {
    String deId;
    String name;
    int contactNo;
    Location currentLocation;
    int lastOrderDeliveredTime;
    int status;

    public String getDeId() {
        return deId;
    }

    public String getName() {
        return name;
    }

    public int getContactNo() {
        return contactNo;
    }

    public Location getCurrentLocation() {
        return currentLocation;
    }

    public int getLastOrderDeliveredTime() {
        return lastOrderDeliveredTime;
    }

    public void setDeId(String deId) {
        this.deId = deId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setContactNo(int contactNo) {
        this.contactNo = contactNo;
    }

    public void setCurrentLocation(Location currentLocation) {
        this.currentLocation = currentLocation;
    }

    public void setLastOrderDeliveredTime(int lastOrderDeliveredTime) {
        this.lastOrderDeliveredTime = lastOrderDeliveredTime;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
