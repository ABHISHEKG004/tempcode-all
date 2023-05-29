package MCexamples.splitwise.driver;

import MCexamples.splitwise.Database.Datastore;
import MCexamples.splitwise.exception.InvalidExpenseException;
import MCexamples.splitwise.models.*;
import MCexamples.splitwise.service.SplitwiseManagerService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;

/** Created by Abhishek gupta on 2019-09-17 */
public class Driver {

  public static void main(String[] args) throws InvalidExpenseException {

    /******REMAINING TASKS (Future work)**********
     *
     * Modify Bill
     * Delete Bill
     * Delete group settlement
     * Multiple payer bill
     * Non group expenses
     * Overall settlement
     * Delete overall settlement
     *
     *******************************/

    //creating users
    User user1 = new User();
    user1.setId("user1");
    user1.setEmail("abc@gmail.com");
    user1.setName("Abhi");
    user1.setGroupIds(new ArrayList<String>());

    User user2 = new User();
    user2.setId("user2");
    user2.setEmail("xyz@gmail.com");
    user2.setName("Rohit");
    user2.setGroupIds(new ArrayList<String>());

    //creating group
    Group group = new Group();
    group.setId("group1");
    group.setName("flatmates");
    group.setUserIds(new ArrayList<String>());
    group.setUserWiseBalance(new HashMap<String, HashMap<String, BigDecimal>>());
    group.setBills(new HashMap<String, Expense>());
    group.setSettlements(new ArrayList<Settlement>());

    group.addUserToGroup(user1);
    group.addUserToGroup(user2);

    //Adding to Datastore
    Datastore.addUser(user1);
    Datastore.addUser(user2);
    Datastore.addGroup(group);


    //Calling methods
    SplitwiseManagerService splitwiseManagerService = new SplitwiseManagerService();

    HashMap<String, BigDecimal> userShare = new HashMap<String, BigDecimal>();
    userShare.put("user1", BigDecimal.valueOf(30));
    userShare.put("user2", BigDecimal.valueOf(70));

    splitwiseManagerService.addExpense(
        "dinner", "user1", "group1", BigDecimal.valueOf(200), userShare, ShareByEnum.PERCENTAGE);

    splitwiseManagerService.getPendingBalanceInGroup("group1", "user1");
    splitwiseManagerService.getPendingBalanceInGroup("group1", "user2");
//    splitwiseManagerService.getPendingBalanceOverall( "user1");

//    splitwiseManagerService.settlePayment("group1", "user2", "user1", BigDecimal.valueOf(120));
    splitwiseManagerService.settlePayment("group1", "user2", "user1", null);

    splitwiseManagerService.getPendingBalanceInGroup("group1", "user1");
    splitwiseManagerService.getPendingBalanceInGroup("group1", "user2");

    //View group settlements
    System.out.println(group.getSettlements());
  }
}
