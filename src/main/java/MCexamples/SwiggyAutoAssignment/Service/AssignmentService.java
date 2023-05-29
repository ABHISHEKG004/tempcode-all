package MCexamples.SwiggyAutoAssignment.Service;

import com.design.lowlevel.mine.SwiggyAutoAssignment.Constants.DEStatus;
import com.design.lowlevel.mine.SwiggyAutoAssignment.Constants.OrderStatus;
import com.design.lowlevel.mine.SwiggyAutoAssignment.Constants.PriorityConstants;
import com.design.lowlevel.mine.SwiggyAutoAssignment.DataStore.Database;
import com.design.lowlevel.mine.SwiggyAutoAssignment.Models.DeliveryExecutive;
import com.design.lowlevel.mine.SwiggyAutoAssignment.Models.Order;
import com.design.lowlevel.mine.SwiggyAutoAssignment.Models.PriorityModel;
import com.design.lowlevel.mine.SwiggyAutoAssignment.Utils.Util;

import java.util.ArrayList;

/**
 * Created by abhishek.gupt on 26/05/18.
 */
public class AssignmentService {
    public static void assignOrdersToDEs(ArrayList<Order> currentOrders, ArrayList<DeliveryExecutive> currentIdleDEs) {

        //Assignment Algorithm (Greedy Aprroach) - not best

        for(Order order : currentOrders){

            double weight = 1000000000.0; // SOME MAX VALUE
            DeliveryExecutive assignedDeliveryExecutive = null;
            for(DeliveryExecutive de : currentIdleDEs){

                if(de.getStatus()==DEStatus.IDLE.getValue()) {
                    double totalWeight = getWeightForOrderAndDeliveryExecutive(order, de);
//                    System.out.println(totalWeight);

                    if (totalWeight < weight) {
                        weight = totalWeight;
                        assignedDeliveryExecutive = de;
                    }
                }
            }

            if(assignedDeliveryExecutive==null){
                order.setStatus(OrderStatus.REJECTED.getValue());
            }else {
                order.setAssignedDE(assignedDeliveryExecutive);
                assignedDeliveryExecutive.setStatus(DEStatus.ACTIVE.getValue());
            }

        }

        printOrdersStatus(currentOrders);
    }

    private static double getWeightForOrderAndDeliveryExecutive(Order order, DeliveryExecutive de){

//        long currentTime = System.currentTimeMillis(); //to be replaced with
        int currentTime = 10000;
        double dis = Util.getDistance(order.getRestaurant().getLocation(), de.getCurrentLocation());
        int deWaitingTime = currentTime - de.getLastOrderDeliveredTime();
        int orderDelayTime = currentTime - order.getOrderTime();

        double weight = 0;
        for(PriorityModel priority : Database.getPriorityList()){
            if(priority.getPriorityName().equals(PriorityConstants.FIRST_MILE.getValue())){
                weight = weight + priority.getWeightFactor()*dis;
            }else if(priority.getPriorityName().equals(PriorityConstants.DE_WAITING_TIME.getValue())){
                weight = weight + priority.getWeightFactor()*deWaitingTime;
            }else if(priority.getPriorityName().equals(PriorityConstants.ORDER_DELAY_TIME.getValue())){
                weight = weight + priority.getWeightFactor()*orderDelayTime;
            }
        }
        return weight;

    }

    public static void printOrdersStatus(ArrayList<Order> currentOrders){

        for(Order order : currentOrders){
            if(order.getAssignedDE()!=null) {
                System.out.println(order.getOrderId() + " will be delivered by " + order.getAssignedDE().getDeId());
            }else{
                System.out.println("Order " + order.getOrderId() + " rejected due to Non-availability of DeliveryExecutive");
            }

        }

    }
}
