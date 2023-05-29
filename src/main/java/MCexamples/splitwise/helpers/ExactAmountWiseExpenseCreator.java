package MCexamples.splitwise.helpers;

import MCexamples.splitwise.exception.InvalidExpenseException;
import MCexamples.splitwise.models.Expense;

import java.math.BigDecimal;
import java.util.Map;

/**
 * Created by Abhishek gupta on 2019-09-17
 */

public class ExactAmountWiseExpenseCreator implements ExpenseCreator{

  public Expense getExpense(String expenseId, String expenseName, String payerId, String groupId,
                            BigDecimal expenseAmount, Map<String, BigDecimal> userShare) throws InvalidExpenseException {


    BigDecimal totalAmount = new BigDecimal("0.0");
    for(BigDecimal share: userShare.values()) {
      totalAmount = totalAmount.add(share);
    }
    if (totalAmount.compareTo(expenseAmount) != 0) {
      throw new InvalidExpenseException("total amount didn't match with expense amount");
    }

    Expense expense = new Expense();
    expense.setExpenseId(expenseId);
    expense.setExpenseName(expenseName);
    expense.setPayerId(payerId);
    expense.setGroupId(groupId);
    expense.setAmount(expenseAmount);
    expense.setUserWiseBillBreakup(userShare);

    return expense;
  }
}
