package MCexamples.SwiggyAutoAssignment.Processor;

import com.design.lowlevel.mine.SwiggyAutoAssignment.Constants.DEStatus;
import com.design.lowlevel.mine.SwiggyAutoAssignment.Constants.OrderStatus;
import com.design.lowlevel.mine.SwiggyAutoAssignment.DataStore.Database;
import com.design.lowlevel.mine.SwiggyAutoAssignment.Models.DeliveryExecutive;
import com.design.lowlevel.mine.SwiggyAutoAssignment.Models.Order;
import com.design.lowlevel.mine.SwiggyAutoAssignment.Service.AssignmentService;

import java.util.ArrayList;

/**
 * Created by abhishek.gupt on 26/05/18.
 */
public class OrderAssignementProcessor {
    public static void assignCurrentOrdersToDEs() {
        ArrayList<Order> currentOrders = new ArrayList<Order>();
        ArrayList<DeliveryExecutive> currentIdleDEs = new ArrayList<DeliveryExecutive>();

        for(Order order : Database.getOrderList()){
            if(order.getStatus()== OrderStatus.PLACED.getValue()){
                currentOrders.add(order);
            }
        }


        for(DeliveryExecutive de : Database.getDeliveryExecutivesList()){
            if(de.getStatus()== DEStatus.IDLE.getValue()){
                currentIdleDEs.add(de);
            }
        }

        AssignmentService.assignOrdersToDEs(currentOrders, currentIdleDEs);
    }
}
