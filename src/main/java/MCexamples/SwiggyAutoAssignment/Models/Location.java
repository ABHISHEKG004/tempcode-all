package MCexamples.SwiggyAutoAssignment.Models;

/**
 * Created by abhishek.gupt on 26/05/18.
 */
public class Location {

    int latitude;
    int longitude;

    public Location(int latitude, int longitude){
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public int getLatitude() {
        return latitude;
    }

    public int getLongitude() {
        return longitude;
    }

    public void setLatitude(int latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(int longitude) {
        this.longitude = longitude;
    }
}
