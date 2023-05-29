package MCexamples.splitwise.helpers;

import MCexamples.splitwise.exception.InvalidExpenseException;
import MCexamples.splitwise.models.Expense;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Abhishek gupta on 2019-09-17
 */

public class PercentageWiseExpenseCreator implements ExpenseCreator{

  public Expense getExpense(String expenseId, String expenseName, String payerId, String groupId,
                            BigDecimal expenseAmount, Map<String, BigDecimal> userShare) throws InvalidExpenseException {


    BigDecimal totalPercentage = new BigDecimal("0.0");
    for(BigDecimal share: userShare.values()) {
      totalPercentage = totalPercentage.add(share);
    }
    if (totalPercentage.compareTo(new BigDecimal("100.0")) != 0) {
      throw new InvalidExpenseException("Total percentage is not equal to 100");
    }

    Map<String, BigDecimal> userWiseBillBreakup = new HashMap<String, BigDecimal>();

    for (String userId: userShare.keySet()) {

      BigDecimal amountOwed = expenseAmount.multiply(userShare.get
          (userId)).divide(new BigDecimal("100.0"));

      userWiseBillBreakup.put(userId, amountOwed);
    }

    Expense expense = new Expense();
    expense.setExpenseId(expenseId);
    expense.setExpenseName(expenseName);
    expense.setPayerId(payerId);
    expense.setGroupId(groupId);
    expense.setAmount(expenseAmount);
    expense.setUserWiseBillBreakup(userWiseBillBreakup);

    return expense;
  }
}
