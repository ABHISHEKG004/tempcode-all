package MCexamples.ridesharing;

import lombok.*;

import java.util.Date;

/**
 * Created by Abhishek gupta on 2019-09-21
 */

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Setter
@ToString
public class Ride {

//  private String rideId;
  private String vehicleId;
  private String driver;
  private String origin;
  private String destination;
  private Date startTime;
  private int seatsAvailable;
  private int duration;//assuming in hours

}
