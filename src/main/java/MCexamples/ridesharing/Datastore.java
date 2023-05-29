package MCexamples.ridesharing;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Abhishek gupta on 2019-09-21
 */

public class Datastore {

  private static HashMap<String, User> users = new HashMap<String, User>();
  private static HashMap<String, Vehicle> vehicles = new HashMap<String, Vehicle>();
  private static HashMap<String, ArrayList<Ride>> originDestRideMap = new HashMap<String, ArrayList<Ride>>();


  public static void addUser(User user){

    if(users.get(user.getUserId())==null){
      users.put(user.getUserId(), user);
    }else{
      System.out.println("User already exits");
    }
  }

  public static void addVehicles(Vehicle vehicle){

    if(vehicles.get(vehicle.getVehicleId())==null){
      vehicles.put(vehicle.getVehicleId(), vehicle);
    }else{
      System.out.println("Vehicle already exits");
    }
  }


  public static void addOrigDestRide(Ride ride){

    String key = ride.getOrigin() + "-" + ride.getDestination();
    if(originDestRideMap.get(key)==null){
      originDestRideMap.put(key, new ArrayList<Ride>());
    }
    originDestRideMap.get(key).add(ride);
  }

  //add null check
  public static User getUser(String userId){
    return users.get(userId);
  }

  public static ArrayList<Ride> getOrigDestRide(String origin, String destination){

    String key = origin + "-" + destination;
    if(originDestRideMap.get(key)!=null){
      return originDestRideMap.get(key);
    }
    return new ArrayList<Ride>();
  }


}
