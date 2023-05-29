package MCexamples.ridesharing;

import lombok.*;

/**
 * Created by Abhishek gupta on 2019-09-21
 */

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Setter
@ToString
public class Vehicle {

  private String vehicleId;
  private String userId;
  private String name;
  private String number;

}
