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
public class Trip {

//  private String tripId;
  private String origin;
  private String destination;
  private String driver;
  private String passenger;
  private String vehicleId;
//  private Double fare;
  private Date startTime;
//  private String status;//make enum

}
