package MCexamples.VenndingMachine;

import lombok.Data;

import java.util.HashMap;


@Data
public class Transaction {

    private String id;
    private Item item;

    // as of now taking date as string for testing purpose
    private String date;
    private Integer amountGivenByUser;
    private HashMap<Coin, Integer> amountGivenByUserBreakup;
    private HashMap<Coin, Integer> changeGivenBySystemBreakup;

}
