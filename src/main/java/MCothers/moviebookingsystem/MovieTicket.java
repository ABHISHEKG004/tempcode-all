package MCothers.moviebookingsystem;

import java.util.Date;
import java.util.HashSet;

/**
 * Created by gaurav.kum on 23/12/17.
 */
public class MovieTicket {
    Theatre theatre;
    Date showTime;
    Movie movieInfo;

    HashSet<Seat> getAvailableSeats(){
        return theatre.getAvailableSeats();
    }

    public boolean commitToBuy(Seat seat) {
        synchronized (this) {
            if (theatre.getAvailableSeats().contains(seat)) {
                theatre.getAvailableSeats().remove(seat);
                return true;
            }
            return false;
        }
    }

    /*We can create a HashMap which stores movie name as key and another HashMap as value.

    HashMap<String, HashMap> map;

    Now this HashMap<TicketCat, Number Of Tickets remaining> where TicketCat could be platinum, Gold, Silver.

    So this way you could be able to allocate tickets faster.*/
}
