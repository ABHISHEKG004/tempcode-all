package MCothers.moviebookingsystem;

import java.util.HashSet;

/**
 * Created by gaurav.kum on 23/12/17.
 */
public class Theatre {
    HashSet<Seat> availableSeats;
    String theatreName;
    String theatreAddress;

    public HashSet<Seat> getAvailableSeats() {
        return availableSeats;
    }
    //other theatre info + setters,getters
}
