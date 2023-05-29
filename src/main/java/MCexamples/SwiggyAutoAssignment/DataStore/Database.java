package MCexamples.SwiggyAutoAssignment.DataStore;

import com.design.lowlevel.mine.SwiggyAutoAssignment.Models.*;

import java.util.ArrayList;

/**
 * Created by abhishek.gupt on 26/05/18.
 */
public class Database {

    private static ArrayList<DeliveryExecutive> deliveryExecutivesList = new ArrayList<DeliveryExecutive>();
    private static ArrayList<Order> orderList = new ArrayList<Order>();
    private static ArrayList<Restaurant> restaurantList = new ArrayList<Restaurant>();
    private static ArrayList<Item> itemList = new ArrayList<Item>();
    private static ArrayList<PriorityModel> priorityList = new ArrayList<PriorityModel>();

    public static ArrayList<DeliveryExecutive> getDeliveryExecutivesList() {
        return deliveryExecutivesList;
    }

    public static ArrayList<Order> getOrderList() {
        return orderList;
    }

    public static ArrayList<Restaurant> getRestaurantList() {
        return restaurantList;
    }

    public static ArrayList<Item> getItemList() {
        return itemList;
    }

    public static ArrayList<PriorityModel> getPriorityList() {
        return priorityList;
    }
}
