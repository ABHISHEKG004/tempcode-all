package MCexamples.parkinglot;

import java.util.HashMap;
import java.util.Optional;
import java.util.TreeSet;

/**
 * Created by Abhishek gupta on 2019-10-14
 */

public class Datastore {


  private static HashMap<String, Vehicle> vehicles = new HashMap<String, Vehicle>();
  private static HashMap<Integer, Slot> slots = new HashMap<Integer, Slot>();

  //for optimizing allocation of free slots
  public static HashMap<Type, TreeSet<Integer>> availableSlotIds = new HashMap<>();
  public static HashMap<Type, TreeSet<Integer>> allocatedSlotIds = new HashMap<>();

  public static Optional<Vehicle> getVehicleInfo(String vehicleNumber){

    return Optional.ofNullable(vehicles.get(vehicleNumber));
  }

  public static void addVehicleInfo(Vehicle vehicle){
      vehicles.put(vehicle.getVehicleNumber(), vehicle);
  }

  public static Optional<Slot> getSlotInfo(Integer slotNumber){

    return Optional.ofNullable(slots.get(slotNumber));
  }

  public static void addOrUpdateSlotInfo(Slot slot){
    slots.put(slot.getSlotNumber(), slot);
  }


}
