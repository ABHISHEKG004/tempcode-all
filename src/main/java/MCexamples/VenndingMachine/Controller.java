package MCexamples.VenndingMachine;


import java.util.HashMap;

public class Controller {


    public static void main(String[] args) {


        VendingMachine vendingMachine = new SimpleVendingMachine();

        vendingMachine.initialise();
        vendingMachine.showAvailableItemsAndPrice();

        HashMap<Coin, Integer> coins = new HashMap<>();

        coins.put(Coin.C4, 4);

        try {
            HashMap<Coin, Integer> change = vendingMachine.buyItem(Item.SODA, coins, "date1");

            if(change==null){
                System.out.println("No change needed from system");
            } else {
                System.out.println("Change returned by system");
                for (Coin coin : change.keySet()) {
                    System.out.println("coin -> " + coin.name() + ", value -> " + coin.getValue() + ", quantity -> " + change.get(coin));
                }
            }

        } catch (Exception e){
            System.out.println(e.getMessage());
        }

        vendingMachine.showTransactionsByDate("date1");

        vendingMachine.showAvailableItemsAndPrice();




//        vendingMachine.reset();
    }
}
