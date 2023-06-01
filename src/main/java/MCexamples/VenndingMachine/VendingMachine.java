package MCexamples.VenndingMachine;


import MCexamples.lowlevel.mine.VenndingMachine.exceptions.*;

import java.util.HashMap;

public interface VendingMachine {

    void initialise();
    HashMap<Coin, Integer> buyItem(Item item, HashMap<Coin, Integer> coins, String date) throws ItemNotFoundException, ChangeNotAvailableException, ItemNotAvailableException, NoSufficientBalance, CoinNotFoundException;
    void reset();
    void showAvailableItemsAndPrice();
    void showTransactionsByDate(String date);

}
