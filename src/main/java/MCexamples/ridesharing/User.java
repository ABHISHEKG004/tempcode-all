package MCexamples.ridesharing;

import lombok.*;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Abhishek gupta on 2019-09-21
 */

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Setter
@ToString
public class User {

  private String userId;
  private String name;
  private String gender;
  private int age;
  private HashMap<String, Vehicle> vehicles;
  private ArrayList<Trip> tripsOffered;
  private ArrayList<Trip> tripsTaken;
  private ArrayList<Ride> rides;

}
