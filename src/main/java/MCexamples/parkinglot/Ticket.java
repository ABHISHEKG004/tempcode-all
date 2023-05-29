package MCexamples.parkinglot;

import lombok.*;

import java.util.Date;

/**
 * Created by Abhishek gupta on 2019-10-14
 */

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Setter
@ToString
public class Ticket {

  private String ticketId;
  private int slotId;
  private double fees;
  private Date dateOfIssue;

}
