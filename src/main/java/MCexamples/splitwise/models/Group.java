package MCexamples.splitwise.models;

import lombok.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Abhishek gupta on 2019-09-17
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Group {
  private String id;
  private String name;
  private ArrayList<String> userIds;
  private HashMap<String, HashMap<String, BigDecimal>> userWiseBalance;
  private HashMap<String, Expense> bills;
  private ArrayList<Settlement> settlements;

  public void addUserToGroup(User user) {

    user.getGroupIds().add(id);
    userIds.add(user.getId());
    userWiseBalance.put(user.getId(), new HashMap<String, BigDecimal>());
  }

  public void addBill(Expense expense) {
    bills.put(expense.getExpenseId(), expense);
  }

  public void addSettlement(Settlement settlement) {
    settlements.add(settlement);
  }
}
