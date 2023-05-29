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
public class Slot {

  private Integer slotNumber;
  private SlotStatus slotStatus;
  private String vehicleNumber;//nullable
//  private String otherInfo;
  private Type type;

}
