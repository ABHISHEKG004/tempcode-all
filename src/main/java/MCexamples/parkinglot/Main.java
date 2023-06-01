package MCexamples.parkinglot;

import java.util.HashMap;

import static MCexamples.parkinglot.Type.*;

/**
 * Created by Abhishek gupta on 2019-10-14
 */

public class Main {

  public static void main(String[] args) {

    Vehicle vehicle1 = new Vehicle("KA-AB-001", "white", "user1", BIKE);
    Vehicle vehicle2 = new Vehicle("KA-AB-002", "black", "user2", BIKE);
    Vehicle vehicle3 = new Vehicle("KA-AB-003", "red", "user3", BIKE);
    Vehicle vehicle4 = new Vehicle("KA-AB-004", "green", "user4", CAR);
    Vehicle vehicle5 = new Vehicle("KA-AB-005", "yellow", "user5", CAR);
    Vehicle vehicle6 = new Vehicle("KA-AB-006", "pink", "user6", TRUCK);



    ParkingLotService parkingLotService = new ParkingLotService();

    //creating parking lot
    HashMap<Type, Integer> typeWiseSlots = new HashMap<>();
    typeWiseSlots.put(BIKE, 2);
    typeWiseSlots.put(CAR, 2);
    typeWiseSlots.put(TRUCK, 2);
    parkingLotService.createParkingSlot(typeWiseSlots);

    //parking vehicle
    parkingLotService.parkVehicle(vehicle1);
    parkingLotService.parkVehicle(vehicle2);
    parkingLotService.parkVehicle(vehicle3);
    parkingLotService.parkVehicle(vehicle4);

    //allocated slots info
    parkingLotService.getAllocatedSlotsInfo();

    //free slots info
    parkingLotService.getAvailableSlotsInfo();


    //vacate slot
    parkingLotService.vacateSlot(5);
    parkingLotService.vacateSlot(3);

    //allocated slots info
    parkingLotService.getAllocatedSlotsInfo();

    //free slots info
    parkingLotService.getAvailableSlotsInfo();

    //parking vehicle
    parkingLotService.parkVehicle(vehicle5);
    parkingLotService.parkVehicle(vehicle6);

  }
}
