package MCexamples.VenndingMachine;

import MCexamples.lowlevel.mine.VenndingMachine.exceptions.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class SimpleVendingMachine implements VendingMachine{


    private ArrayList<Transaction> transactions;
    private InventoryService inventoryService;

    public SimpleVendingMachine(){
        inventoryService = new InventoryService();
        transactions = new ArrayList<>();
    }


    public void initialise() {

        System.out.println("********** Initialising System ***********");

        for(Item item : Item.values()){

            inventoryService.addItem(item,1);
        }

        for(Coin coin : Coin.values()){
            inventoryService.addCoin(coin,5);
        }

        System.out.println("********** Initialising Done ***********");
    }

    @Override
    public HashMap<Coin, Integer> buyItem(Item item, HashMap<Coin, Integer> coins, String date)
            throws ItemNotFoundException, ChangeNotAvailableException, ItemNotAvailableException,
            NoSufficientBalance, CoinNotFoundException {

        System.out.println("********** Buying item from System ***********");
        System.out.println("Details below");
        System.out.println("item -> " + item + ", coinsByUser -> " + coins + ", date -> " + date);

        //Basic Validations
        if(!checkIfItemAvailable(item)){
            throw new ItemNotAvailableException(item + " not available as of now, please check later");
        }

        Integer totalAmountGivenByUser = getTotalAmount(coins);
        Integer changeAmount = totalAmountGivenByUser - item.getPrice();

        if(changeAmount<0){
            throw new NoSufficientBalance( Math.abs(changeAmount) + " more amount is required to buy item " + item);
        }


        //Paying and getting change and item from System
        addCoinsIntoSystem(coins);

        if(changeAmount>0 && !checkIfChangeAvailable(changeAmount)){
            throw new ChangeNotAvailableException("change not available as of now, can't place order. please check later");
        }

        removeItemFromSystem(item);
        HashMap<Coin, Integer> change = null;

        if(changeAmount>0) {
            change = getChangeFromSystem(changeAmount);
        }


        //When everything is fine, add txn to system
        Transaction transaction = new Transaction();
        transaction.setId(UUID.randomUUID().toString());
        transaction.setDate(date);
        transaction.setItem(item);
        transaction.setAmountGivenByUser(totalAmountGivenByUser);
        transaction.setAmountGivenByUserBreakup(coins);
        transaction.setChangeGivenBySystemBreakup(change);
        transactions.add(transaction);

        System.out.println("Successfully Buyed item from System");

        return change;
    }

    private boolean checkIfChangeAvailable(Integer changeAmount) {

        return inventoryService.checkChangeAvailable(changeAmount);
    }

    private HashMap<Coin, Integer> getChangeFromSystem(Integer changeAmount) throws CoinNotFoundException {

        return inventoryService.getChange(changeAmount);
    }

    private void removeItemFromSystem(Item item) throws ItemNotFoundException {

        inventoryService.removeItem(item, 1);
    }

    private void addCoinsIntoSystem(HashMap<Coin, Integer> coins) {

        for (Coin coin : coins.keySet())
        {
            Integer quantity = coins.get(coin);
            inventoryService.addCoin(coin, quantity);

        }
    }

    private Integer getTotalAmount(HashMap<Coin, Integer> coins) {

        Integer amount = 0;
        for (Coin coin : coins.keySet())
        {
            Integer quantity = coins.get(coin);

            amount = amount + quantity*coin.getValue();
        }
        return amount;
    }

    private boolean checkIfItemAvailable(Item item) {

        return inventoryService.getItemCount(item)>0;
    }

    @Override
    public void reset() {

        System.out.println("********** Resetting System ***********");
        transactions.clear();
        inventoryService.reset();
        System.out.println("********** Resetting done ***********");
    }

    @Override
    public void showAvailableItemsAndPrice() {

        System.out.println("********** AvailableItemsAndPrice ***********");

        ArrayList<Item> availableItems = inventoryService.getAvaialbleItems();

        for(Item item : availableItems){
            System.out.println("item -> " + item.name() + " , price ->" + item.getPrice());
        }
    }

    @Override
    public void showTransactionsByDate(String date){

        System.out.println("********** Transactions ***********");
        for(Transaction transaction : transactions){
            if(transaction.getDate().equals(date)){
                System.out.println(transaction);
            }
        }
    }
}
