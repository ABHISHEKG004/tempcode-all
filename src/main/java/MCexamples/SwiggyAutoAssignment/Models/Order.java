package MCexamples.SwiggyAutoAssignment.Models;

import java.util.ArrayList;

/**
 * Created by abhishek.gupt on 26/05/18.
 */
public class Order {

    private String orderId;
    private ArrayList<Item> items = new ArrayList<Item>();
    private int orderTime;
    private Restaurant restaurant;
    private int status;
    private double amountCharged;
    private DeliveryExecutive assignedDE;


    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    public String getOrderId() {
        return orderId;
    }

    public int getOrderTime() {
        return orderTime;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public int getStatus() {
        return status;
    }

    public double getAmountCharged() {
        return amountCharged;
    }

    public DeliveryExecutive getAssignedDE() {
        return assignedDE;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public void setOrderTime(int orderTime) {
        this.orderTime = orderTime;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setAmountCharged(double amountCharged) {
        this.amountCharged = amountCharged;
    }

    public void setAssignedDE(DeliveryExecutive assignedDE) {
        this.assignedDE = assignedDE;
    }
}
