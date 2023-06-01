package MCexamples.parkinglot;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.TreeSet;

import static MCexamples.parkinglot.Datastore.*;
import static MCexamples.parkinglot.SlotStatus.AVAILABLE;
import static MCexamples.parkinglot.SlotStatus.OCCUPIED;

/**
 * Created by Abhishek gupta on 2019-10-14
 */

public class ParkingLotService {

  public void createParkingSlot(HashMap<Type, Integer> typeWiseSlots){

    System.out.println();
    int slotNo = 1;
    for (Map.Entry<Type,Integer> entry : typeWiseSlots.entrySet()){
      Type typeOfSlot = entry.getKey();
      Integer countOfSlots = entry.getValue();

      for(int i =1;i<=countOfSlots;i++){
        Slot slot= new Slot(slotNo,AVAILABLE,null, typeOfSlot);

        //adding slot info in datstore;
        Datastore.addOrUpdateSlotInfo(slot);
        if(availableSlotIds.get(typeOfSlot)==null){
          availableSlotIds.put(typeOfSlot, new TreeSet<>());
          allocatedSlotIds.put(typeOfSlot, new TreeSet<>());
        }
        availableSlotIds.get(typeOfSlot).add(slot.getSlotNumber());
        slotNo++;
      }
    }

    System.out.println("Successfully create parking lot with type wise slots " + typeWiseSlots);
  }

  public void parkVehicle(Vehicle vehicle){

    synchronized (this) {
        System.out.println();
        try {
          // adding vehicle info in datstore;
          Datastore.addVehicleInfo(vehicle);
          Type typeOfSlot = vehicle.getType();

          // allocate nearest free slot
          if (availableSlotIds.get(typeOfSlot).isEmpty()) {
            System.out.println("Sorry!! Parking lot is full for " + typeOfSlot);
          } else {
            Integer nearestAvailableSlot = availableSlotIds.get(typeOfSlot).first();
            occupySlot(nearestAvailableSlot, typeOfSlot);
            Slot slot = getSlotInfo(nearestAvailableSlot).get();
            slot.setSlotStatus(OCCUPIED);
            slot.setVehicleNumber(vehicle.getVehicleNumber());
            System.out.println("Successfully parked vehicle " + typeOfSlot + " at slot number " + nearestAvailableSlot);
          }
        } catch (Exception e) {
          System.out.println("Exception occurred : " + e);
        }
    }

  }

  public void vacateSlot(int slotNumber){

    System.out.println();
    try{

      Optional<Slot> slot = getSlotInfo(slotNumber);

      if(slot.isPresent()){

        Type type = slot.get().getType();
        if (allocatedSlotIds.get(type)!=null && allocatedSlotIds.get(type).contains(slotNumber)) {
          freeSlot(slotNumber, type);
          slot.get().setSlotStatus(AVAILABLE);
          slot.get().setVehicleNumber(null);
          System.out.println("successfully free slot number " + slotNumber);
        }else{
          System.out.println("Slot " + slotNumber + " is already freed");
        }

      }else{
        System.out.println("Slot " + slotNumber + " doesn't exist");
      }

    } catch (Exception e){
      System.out.println("Exception occurred : " + e);
    }

  }

  public void getAllocatedSlotsInfo(){

    System.out.println();
    int allocatedSlots = 0;
    for (Map.Entry<Type,TreeSet<Integer>> entry : allocatedSlotIds.entrySet()){
      allocatedSlots = allocatedSlots + entry.getValue().size();
    }
    System.out.println("Total Number of Allocated slots are : " + allocatedSlots);



    for (Map.Entry<Type,TreeSet<Integer>> entry : allocatedSlotIds.entrySet()){
      int currAllocatedSlots = entry.getValue().size();

      if(currAllocatedSlots>0){
        System.out.println("Details");
        System.out.println("Slot_no " + "\t" + "Registration" + "\t" + "Color" + "\t" + entry.getKey());
        for(Integer slotNumber : entry.getValue()){
          Optional<Slot> slot = getSlotInfo(slotNumber);
          if(slot.isPresent()){
            String color = getVehicleInfo(slot.get().getVehicleNumber()).get().getColor();
            System.out.println(slotNumber + "\t" + slot.get().getVehicleNumber() + "\t" +color);
          }else{
            System.out.println("slotInfo doesn't exist with slotNumber " + slotNumber);
          }
        }
      }
    }


  }

  public void getAvailableSlotsInfo(){

    System.out.println();
    int freeSlots = 0;
    for (Map.Entry<Type,TreeSet<Integer>> entry : availableSlotIds.entrySet()){
      freeSlots = freeSlots + entry.getValue().size();
    }
    System.out.println("Total Number of Free slots are : " + freeSlots);
  }


  private void freeSlot(Integer slotNumber, Type type) throws InvalidSlotException {
    if(Datastore.getSlotInfo(slotNumber).isPresent()){
      availableSlotIds.get(type).add(slotNumber);
      allocatedSlotIds.get(type).remove(slotNumber);
    }else{
      String msg = "Sorry!! slotInfo doesn't exist with slotNumber " + slotNumber;
      throw new InvalidSlotException(msg);
    }
  }

  private void occupySlot(Integer slotNumber , Type type) throws InvalidSlotException {
    if(Datastore.getSlotInfo(slotNumber).isPresent()){
      availableSlotIds.get(type).remove(slotNumber);
      allocatedSlotIds.get(type).add(slotNumber);
    }else{
      String msg = "Sorry!! slotInfo doesn't exist with slotNumber " + slotNumber;
      throw new InvalidSlotException(msg);
    }
  }
}
