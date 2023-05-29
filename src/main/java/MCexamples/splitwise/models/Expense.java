package MCexamples.splitwise.models;

import lombok.*;

import java.math.BigDecimal;
import java.util.Map;

/**
 * Created by Abhishek gupta on 2019-09-17
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Expense {

  private String expenseId;
  private String expenseName;
  //Assuming single payer
  private String payerId;
  private BigDecimal amount;
  private String groupId;
  private Map<String, BigDecimal> userWiseBillBreakup;

}
