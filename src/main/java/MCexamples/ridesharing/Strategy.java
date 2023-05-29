package MCexamples.ridesharing;

import java.util.ArrayList;

/**
 * Created by Abhishek gupta on 2019-09-21
 */

public interface Strategy {

  Ride getRide(ArrayList<Ride> rides, int seats);

}
