package MCexamples.splitwise.models;

import lombok.*;

import java.math.BigDecimal;

/**
 * Created by Abhishek gupta on 2019-09-17
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Settlement {

  private String settlementId;
  private String payerId;
  private String receiverId;
  private BigDecimal amount;
  private String groupId;

}
