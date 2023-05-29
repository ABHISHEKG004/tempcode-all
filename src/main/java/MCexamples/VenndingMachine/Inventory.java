package MCexamples.VenndingMachine;

import lombok.Data;

import java.util.concurrent.ConcurrentHashMap;

@Data
public class Inventory {

    //using concurrent here incase dealing with multiple users, where it is not needed using simple map
    private ConcurrentHashMap<Coin, Integer> coinInventory;
    private ConcurrentHashMap<Item, Integer> itemInventory;

    public Inventory(){
        this.coinInventory = new ConcurrentHashMap<>();
        this.itemInventory = new ConcurrentHashMap<>();
    }
}
