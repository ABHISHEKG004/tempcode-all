package MCexamples.VenndingMachine;

import com.design.lowlevel.mine.VenndingMachine.exceptions.CoinNotFoundException;
import com.design.lowlevel.mine.VenndingMachine.exceptions.ItemNotFoundException;

import java.util.ArrayList;
import java.util.HashMap;

import static com.design.lowlevel.mine.VenndingMachine.Coin.*;

public class InventoryService {

    private Inventory inventory;

    public InventoryService(){
        inventory = new Inventory();
    }

    public void addItem(Item item, Integer count){

        if(inventory.getItemInventory().get(item)==null){
            inventory.getItemInventory().put(item, 0);
        }
        inventory.getItemInventory().put(item, inventory.getItemInventory().get(item) + count);
    }

    public void removeItem(Item item, Integer count) throws ItemNotFoundException {

        if(inventory.getItemInventory().get(item)==null){
            throw new ItemNotFoundException(item + " not found");
        }
        inventory.getItemInventory().put(item, inventory.getItemInventory().get(item) - count);
    }

    public Integer getItemCount(Item item){

        Integer count = inventory.getItemInventory().get(item);
        return count==null?0:count;
    }


    public void addCoin(Coin coin, int count) {

        if(inventory.getCoinInventory().get(coin)==null){
            inventory.getCoinInventory().put(coin, 0);
        }
        inventory.getCoinInventory().put(coin, inventory.getCoinInventory().get(coin) + count);
    }

    public void removeCoin(Coin coin, Integer count) throws CoinNotFoundException {

        if(inventory.getCoinInventory().get(coin)==null){
            throw new CoinNotFoundException(coin + " not found");
        }
        inventory.getCoinInventory().put(coin, inventory.getCoinInventory().get(coin) - count);
    }

    public Integer getCoinCount(Coin coin){

        Integer count = inventory.getCoinInventory().get(coin);
        return count==null?0:count;
    }

    public ArrayList<Item> getAvaialbleItems() {


        ArrayList<Item> items = new ArrayList<>();
            for (Item item : inventory.getItemInventory().keySet())
            {
                Integer count = inventory.getItemInventory().get(item);
                if(count!= null && count>0){
                    items.add(item);
                }
            }
            return items;
    }

    public void reset() {

        inventory.getItemInventory().clear();
        inventory.getCoinInventory().clear();
    }

    public boolean checkChangeAvailable(Integer changeAmount) {

        //Creating arraylist to define order of iteration for greedy approach from max to lowest denomination
        ArrayList<Coin> coins = getCoinsFromMaxToLowestDenomination();

        Integer amount = changeAmount;

        for(Coin coin : coins){

            Integer maxRequiredCoins = amount/coin.getValue();

            Integer exactCoinsUsed = Math.min(maxRequiredCoins, inventory.getCoinInventory().get(coin));

            amount = amount - exactCoinsUsed*coin.getValue();
        }

        return amount==0;
    }

    public HashMap<Coin, Integer> getChange(Integer changeAmount) throws CoinNotFoundException {

        //Creating arraylist to define order of iteration for greedy approach from max to lowest denomination
        ArrayList<Coin> coins = getCoinsFromMaxToLowestDenomination();

        HashMap<Coin, Integer> changeBreakup = new HashMap<>();

        Integer amount = changeAmount;

        for(Coin coin : coins){

            Integer maxRequired = amount/coin.getValue();

            Integer exactCoinsUsed = Math.min(maxRequired, inventory.getCoinInventory().get(coin));

            amount = amount - exactCoinsUsed*coin.getValue();

            removeCoin(coin, exactCoinsUsed);

            if(exactCoinsUsed>0)
            changeBreakup.put(coin, exactCoinsUsed);
        }

        return changeBreakup;
    }


    private ArrayList<Coin> getCoinsFromMaxToLowestDenomination(){
        ArrayList<Coin> coins = new ArrayList<>();
        coins.add(C4);
        coins.add(C3);
        coins.add(C2);
        coins.add(C1);

        return coins;
    }

}
