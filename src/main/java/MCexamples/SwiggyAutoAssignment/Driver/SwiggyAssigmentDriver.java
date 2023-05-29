package MCexamples.SwiggyAutoAssignment.Driver;

import com.design.lowlevel.mine.SwiggyAutoAssignment.Constants.DEStatus;
import com.design.lowlevel.mine.SwiggyAutoAssignment.Constants.OrderStatus;
import com.design.lowlevel.mine.SwiggyAutoAssignment.DataStore.Database;
import com.design.lowlevel.mine.SwiggyAutoAssignment.Models.*;
import com.design.lowlevel.mine.SwiggyAutoAssignment.Processor.OrderAssignementProcessor;
import com.design.lowlevel.mine.SwiggyAutoAssignment.Utils.Util;

/**
 * Created by abhishek.gupt on 26/05/18.
 */
public class SwiggyAssigmentDriver {

    public static void main(String[] args) {

        //Add Restaurants
        Restaurant r1 = new Restaurant("r1","ABC", "address1", new Location(13 ,17), 2442, 4.3);
        Restaurant r2 = new Restaurant("r2", "XYZ", "address2", new Location(24, 76), 1437, 4.1);
        Database.getRestaurantList().add(r1);
        Database.getRestaurantList().add(r2);

        //Add Items
        Item i1 = new Item("item1", "Samosa", 23.5);
        Item i2 = new Item("item2", "Pizza", 200.0);
        Item i3 = new Item("item3", "Burger", 50.0);
        Database.getItemList().add(i1);
        Database.getItemList().add(i2);
        Database.getItemList().add(i3);

        //Add Priorities
        PriorityModel p1 = new PriorityModel("priority1", "First Mile", 1);
        PriorityModel p2 = new PriorityModel("priority2", "DE Waiting Time", 1);
        PriorityModel p3 = new PriorityModel("priority3", "Order Delay Time", 1);
        Database.getPriorityList().add(p1);
        Database.getPriorityList().add(p2);
        Database.getPriorityList().add(p3);



        //Add Orders
        Order order1 = new Order();
        order1.setOrderId("order1");
        order1.getItems().add(i1);
        order1.getItems().add(i2);
        order1.setOrderTime(134);
        order1.setRestaurant(r1);
        order1.setStatus(OrderStatus.PLACED.getValue());
        order1.setAmountCharged(Util.getCostForItems(order1.getItems()));
        order1.setAssignedDE(null);

        Order order2 = new Order();
        order2.setOrderId("order2");
        order2.getItems().add(i2);
        order2.getItems().add(i3);
        order2.setOrderTime(254);
        order2.setRestaurant(r2);
        order2.setStatus(OrderStatus.PLACED.getValue());
        order2.setAmountCharged(Util.getCostForItems(order2.getItems()));
        order2.setAssignedDE(null);

        Database.getOrderList().add(order1);
        Database.getOrderList().add(order2);



        //Add Delivery Executives

        DeliveryExecutive deliveryExecutive1 = new DeliveryExecutive();
        deliveryExecutive1.setDeId("DE1");
        deliveryExecutive1.setName("Raju");
        deliveryExecutive1.setContactNo(2334);
        deliveryExecutive1.setCurrentLocation(new Location(102,454));
        deliveryExecutive1.setLastOrderDeliveredTime(4);
        deliveryExecutive1.setStatus(DEStatus.IDLE.getValue());

        DeliveryExecutive deliveryExecutive2 = new DeliveryExecutive();
        deliveryExecutive2.setDeId("DE2");
        deliveryExecutive2.setName("Vishal");
        deliveryExecutive2.setContactNo(2636);
        deliveryExecutive2.setCurrentLocation(new Location(52,234));
        deliveryExecutive2.setLastOrderDeliveredTime(10);
        deliveryExecutive2.setStatus(DEStatus.IDLE.getValue());

        Database.getDeliveryExecutivesList().add(deliveryExecutive1);
        Database.getDeliveryExecutivesList().add(deliveryExecutive2);


        OrderAssignementProcessor.assignCurrentOrdersToDEs();

    }



//    int[] array = {0, 1, 2, 3, 4};
//        do {  // Must start at lowest permutation
//        System.out.println(Arrays.toString(array));
//    } while (nextPermutation(array));

}
