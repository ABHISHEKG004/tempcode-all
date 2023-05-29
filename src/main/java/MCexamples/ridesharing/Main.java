package MCexamples.ridesharing;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

/**
 * Created by Abhishek gupta on 2019-09-21
 */

public class Main {

  public static void main(String[] args){

    //user1
    User user1 = new User();
    user1.setUserId("user1");
    user1.setName("Rohan");
    user1.setGender("M");
    user1.setAge(21);
    user1.setVehicles(new HashMap<String, Vehicle>());
    user1.setTripsOffered(new ArrayList<Trip>());
    user1.setTripsTaken(new ArrayList<Trip>());
    user1.setRides(new ArrayList<Ride>());

    Vehicle vehicle1 = new Vehicle();
    vehicle1.setVehicleId("vehicle1");
    vehicle1.setUserId("user1");
    vehicle1.setName("Swift");
    vehicle1.setNumber("KA-12-0001");

    user1.getVehicles().put(vehicle1.getVehicleId(), vehicle1);



    //user2
    User user2 = new User();
    user2.setUserId("user2");
    user2.setName("Shashank");
    user2.setGender("M");
    user2.setAge(21);
    user2.setVehicles(new HashMap<String, Vehicle>());
    user2.setTripsOffered(new ArrayList<Trip>());
    user2.setTripsTaken(new ArrayList<Trip>());
    user2.setRides(new ArrayList<Ride>());

    Vehicle vehicle2 = new Vehicle();
    vehicle2.setVehicleId("vehicle2");
    vehicle2.setUserId("user2");
    vehicle2.setName("Baleno");
    vehicle2.setNumber("KA-12-0002");

    user2.getVehicles().put(vehicle2.getVehicleId(), vehicle2);

    //User3
    User user3 = new User();
    user3.setUserId("user3");
    user3.setName("Nandini");
    user3.setGender("F");
    user3.setAge(21);
    user3.setVehicles(new HashMap<String, Vehicle>());
    user3.setTripsOffered(new ArrayList<Trip>());
    user3.setTripsTaken(new ArrayList<Trip>());
    user3.setRides(new ArrayList<Ride>());

    //User4
    User user4 = new User();
    user4.setUserId("user4");
    user4.setName("Gaurav");
    user4.setGender("M");
    user4.setAge(21);
    user4.setVehicles(new HashMap<String, Vehicle>());
    user4.setTripsOffered(new ArrayList<Trip>());
    user4.setTripsTaken(new ArrayList<Trip>());
    user4.setRides(new ArrayList<Ride>());

    //User5
    User user5 = new User();
    user5.setUserId("user5");
    user5.setName("Shipra");
    user5.setGender("F");
    user5.setAge(21);
    user5.setVehicles(new HashMap<String, Vehicle>());
    user5.setTripsOffered(new ArrayList<Trip>());
    user5.setTripsTaken(new ArrayList<Trip>());
    user5.setRides(new ArrayList<Ride>());

    Vehicle vehicle3 = new Vehicle();
    vehicle3.setVehicleId("vehicle3");
    vehicle3.setUserId("user5");
    vehicle3.setName("Polo");
    vehicle3.setNumber("KA-12-0003");

    Vehicle vehicle4 = new Vehicle();
    vehicle4.setVehicleId("vehicle4");
    vehicle4.setUserId("user5");
    vehicle4.setName("Scooty");
    vehicle4.setNumber("KA-12-0004");

    user5.getVehicles().put(vehicle3.getVehicleId(), vehicle3);
    user5.getVehicles().put(vehicle4.getVehicleId(), vehicle4);



    //calling ride sharing service and methods
    RideSharingService rideSharingService = new RideSharingService();

    //adding user and vehicles into the system
    rideSharingService.addUser(user1);
    rideSharingService.addUser(user2);
    rideSharingService.addUser(user3);
    rideSharingService.addUser(user4);
    rideSharingService.addUser(user5);

    rideSharingService.addVehicle(vehicle1);
    rideSharingService.addVehicle(vehicle2);
    rideSharingService.addVehicle(vehicle3);
    rideSharingService.addVehicle(vehicle4);

    //offer rides
    rideSharingService.offerRide(
        "user1", "vehicle1", 2, "Hyderabad", "Bangalore",
        new Date(2019, 1, 1, 10, 0), 15);

    rideSharingService.offerRide(
        "user2", "vehicle2", 2, "Hyderabad", "Bangalore",
        new Date(2019, 1, 2, 10, 0), 10);

    rideSharingService.offerRide(
        "user5", "vehicle4", 1, "Hyderabad", "Bangalore",
        new Date(2019, 1, 1, 10, 0), 12);



    //select ride
    rideSharingService.selectRide("user3" , "Hyderabad", "Bangalore", 1, new FastestStrategy());
    rideSharingService.selectRide("user3" , "Hyderabad", "Bangalore", 1, new FastestStrategy());
    rideSharingService.selectRide("user3" , "Hyderabad", "Bangalore", 1, new FastestStrategy());

    rideSharingService.selectRide("user4" , "Hyderabad", "Bangalore", 1,new EarliestStrategy());


    //stats
    rideSharingService.showUserStats("user1");
    rideSharingService.showUserStats("user2");
    rideSharingService.showUserStats("user3");
    rideSharingService.showUserStats("user4");
    rideSharingService.showUserStats("user5");
  }
}
