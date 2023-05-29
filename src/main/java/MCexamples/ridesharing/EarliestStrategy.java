package MCexamples.ridesharing;

import java.util.ArrayList;
import java.util.Date;

/** Created by Abhishek gupta on 2019-09-21 */
public class EarliestStrategy implements Strategy {

  public Ride getRide(ArrayList<Ride> rides, int seats) {
    Ride bestRide = null;

    if (rides.isEmpty()) {
      return null;
    }

    Date earliestDate =
        Utils.addHoursToJavaUtilDate(rides.get(0).getStartTime(), rides.get(0).getDuration());
    for (Ride ride : rides) {

      Date currArrivalTime = Utils.addHoursToJavaUtilDate(ride.getStartTime(), ride.getDuration());
      if (ride.getSeatsAvailable() >= seats && currArrivalTime.compareTo(earliestDate) <= 0) {
        earliestDate = currArrivalTime;
        bestRide = ride;
      }
    }
    return bestRide;
  }
}
