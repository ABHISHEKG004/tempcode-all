package MCexamples.splitwise.service;

import MCexamples.splitwise.Database.Datastore;
import MCexamples.splitwise.exception.InvalidExpenseException;
import MCexamples.splitwise.helpers.ExactAmountWiseExpenseCreator;
import MCexamples.splitwise.helpers.ExpenseCreator;
import MCexamples.splitwise.helpers.PercentageWiseExpenseCreator;
import MCexamples.splitwise.models.Expense;
import MCexamples.splitwise.models.Group;
import MCexamples.splitwise.models.Settlement;
import MCexamples.splitwise.models.ShareByEnum;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static MCexamples.splitwise.models.ShareByEnum.PERCENTAGE;

/** Created by Abhishek gupta on 2019-09-17 */
public class SplitwiseManagerService {

  public void addExpense(
      String expenseName,
      String payerId,
      String groupId,
      BigDecimal expenseAmount,
      Map<String, BigDecimal> userShare,
      ShareByEnum shareBy)
      throws InvalidExpenseException {

    String expenseId = UUID.randomUUID().toString();

    Expense expense =
        getExpenseCreator(shareBy)
            .getExpense(expenseId, expenseName, payerId, groupId, expenseAmount, userShare);

    Group group = Datastore.geGroup(groupId);

    if (group != null) {

      System.out.println("Adding expense : " + expense + " to group : " + groupId);
      group.addBill(expense);
      updateUserWiseBalanceForBill(group, expense);

    } else {
      System.out.println("group doesn't exist for groupId : " + groupId);
      // throw some exception
    }
  }

  private void updateUserWiseBalanceForBill(Group group, Expense expense) {

    String payer = expense.getPayerId();
    HashMap<String, BigDecimal> userWiseBalanceForPayer = group.getUserWiseBalance().get(payer);

    for (String userId : expense.getUserWiseBillBreakup().keySet()) {
      BigDecimal amountInvolved = expense.getUserWiseBillBreakup().get(userId);

      if (!userId.equals(payer)) {
        // update payer balance
        if (userWiseBalanceForPayer.get(userId) == null) {
          userWiseBalanceForPayer.put(userId, new BigDecimal(0));
        }
        userWiseBalanceForPayer.put(
            userId, userWiseBalanceForPayer.get(userId).add(amountInvolved));

        // update receiver balance
        HashMap<String, BigDecimal> userWiseBalanceForReceiver =
            group.getUserWiseBalance().get(userId);
        if (userWiseBalanceForReceiver.get(payer) == null) {
          userWiseBalanceForReceiver.put(payer, new BigDecimal(0));
        }
        userWiseBalanceForReceiver.put(
            payer, userWiseBalanceForReceiver.get(payer).subtract(amountInvolved));
      }
    }
  }

  private ExpenseCreator getExpenseCreator(ShareByEnum shareBy) {

    if (PERCENTAGE.equals(shareBy)) {
      return new PercentageWiseExpenseCreator();
    } else {
      // EXACT_AMOUNT
      return new ExactAmountWiseExpenseCreator();
    }
  }

  public void getPendingBalanceInGroup(String groupId, String userId) {
    System.out.println("Pending balance for UserId " + userId + " in groupId " + groupId);
    Group group = Datastore.geGroup(groupId);
    if (group != null) {
      HashMap<String, BigDecimal> userWiseBalance = group.getUserWiseBalance().get(userId);
      System.out.println(userWiseBalance);
    }
  }

  public void getPendingBalanceOverall(String userId) {
    System.out.println("Overall Pending balance for UserId " + userId);
    ArrayList<String> groups = Datastore.getUser(userId).getGroupIds();
    for (String groupId : groups) {
      getPendingBalanceInGroup(groupId, userId);
    }
  }

  /**
   * Custom settlePayment i.e, if amount in argument is null , then settle whatever amount is owed by settler
   *
   * @param groupId
   * @param payerId
   * @param receiverId
   * @param amount
   */
  public void settlePayment(String groupId, String payerId, String receiverId, BigDecimal amount) {

    Group group = Datastore.geGroup(groupId);
    if (group != null) {
      String settlementId = UUID.randomUUID().toString();

      if(amount==null){
        amount = group.getUserWiseBalance().get(receiverId).get(payerId);
      }
      System.out.println(amount);
      if(amount.compareTo(BigDecimal.ZERO)<0){
        System.out.println("Can't settle as " + payerId + " doesn't owe any amount to " + receiverId);
        return;
      }

      Settlement settlement = new Settlement(settlementId, payerId, receiverId, amount, groupId);
      group.addSettlement(settlement);
      updateUserWiseBalanceForSettlement(group, settlement);
    }else{
      System.out.println("group doesn't exist for groupId : " + groupId);
      // throw some exception
    }
  }

  private void updateUserWiseBalanceForSettlement(Group group, Settlement settlement) {

    String payer = settlement.getPayerId();
    String receiver = settlement.getReceiverId();
    BigDecimal amountInvolved = settlement.getAmount();

    // update payer balance
    HashMap<String, BigDecimal> userWiseBalanceForPayer = group.getUserWiseBalance().get(payer);
    if (userWiseBalanceForPayer.get(receiver) == null) {
      userWiseBalanceForPayer.put(receiver, new BigDecimal(0));
    }
    userWiseBalanceForPayer.put(
        receiver, userWiseBalanceForPayer.get(receiver).add(amountInvolved));

    // update receiver balance
    HashMap<String, BigDecimal> userWiseBalanceForReceiver =
        group.getUserWiseBalance().get(receiver);
    if (userWiseBalanceForReceiver.get(payer) == null) {
      userWiseBalanceForReceiver.put(payer, new BigDecimal(0));
    }
    userWiseBalanceForReceiver.put(
        payer, userWiseBalanceForReceiver.get(payer).subtract(amountInvolved));
  }
}
