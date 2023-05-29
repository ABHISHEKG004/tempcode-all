package MCexamples.parkinglot;

import lombok.*;

/**
 * Created by Abhishek gupta on 2019-10-14
 */

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Setter
@ToString
public class Vehicle {

  private String vehicleNumber;
  private String color;
//  private String otherInfo;
  private String ownerId;
  private Type type;


}
