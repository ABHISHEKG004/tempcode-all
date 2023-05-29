package MCexamples.ridesharing;

import java.util.ArrayList;

/**
 * Created by Abhishek gupta on 2019-09-21
 */

public class FastestStrategy implements Strategy{

  public Ride getRide(ArrayList<Ride> rides, int seats) {

    Ride bestRide = null;

    //some max value
    int duration = 100000;

    for(Ride ride : rides){
      if(ride.getSeatsAvailable()>=seats && ride.getDuration()<duration){
        duration = ride.getDuration();
        bestRide = ride;
      }
    }
    return bestRide;
  }
}
