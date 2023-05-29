package MCexamples.splitwise.helpers;

import MCexamples.splitwise.exception.InvalidExpenseException;
import MCexamples.splitwise.models.Expense;

import java.math.BigDecimal;
import java.util.Map;

/** Created by Abhishek gupta on 2019-09-17 */
public interface ExpenseCreator {

  Expense getExpense(
          String expenseId,
          String expenseName,
          String payerId,
          String groupId,
          BigDecimal expenseAmount,
          Map<String, BigDecimal> userShare) throws InvalidExpenseException;
}
