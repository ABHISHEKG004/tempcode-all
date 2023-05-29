package MCexamples.ridesharing;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Abhishek gupta on 2019-09-21
 */

public class RideSharingService {

  public void selectRide(
      String passengerId, String origin, String destination, int seats, Strategy strategy) {
    ArrayList<Ride> rides = Datastore.getOrigDestRide(origin, destination);

    Ride ride = strategy.getRide(rides, seats);

    // if no rides available
    if (ride == null) {
      System.out.println("Sorry!! no ride found for passenger " + passengerId);
      return;
    }

    int initialSeats = ride.getSeatsAvailable();
    ride.setSeatsAvailable(initialSeats - seats);

    Trip trip = getTrip(passengerId, ride);

    User passenger = getUser(passengerId);
    User driver = getUser(ride.getDriver());

    // null checks
    if (passenger == null) {
      System.out.println("passengerId " + passengerId + " is not present in our system");
      return;
    }
    if (driver == null) {
      System.out.println("driverId " + ride.getDriver() + " is not present in our system");
      return;
    }

    passenger.getTripsTaken().add(trip);
    driver.getTripsOffered().add(trip);

    System.out.println("Selected ride for passengerId : " + passengerId + " with name " + passenger.getName() + " is " + ride);
  }

  public void offerRide(
      String userId,
      String vehicleId,
      int availableSeats,
      String origin,
      String destination,
      Date startTime,
      int duration) {

    User user = getUser(userId);

    // null checks
    if (user == null) {
      System.out.println("User " + userId + " is not present in our system");
      return;
    }
    if (user.getVehicles().get(vehicleId) == null) {
      System.out.println("Vehicle " + vehicleId + " doesn't belong to user " + userId);
      return;
    }

    Ride ride = new Ride();
    ride.setVehicleId(vehicleId);
    ride.setDriver(userId);
    ride.setOrigin(origin);
    ride.setDestination(destination);
    ride.setSeatsAvailable(availableSeats);
    ride.setStartTime(startTime);
    ride.setDuration(duration);

    Datastore.addOrigDestRide(ride);
    user.getRides().add(ride);
  }

  public void showUserStats(String userId) {
    User user = Datastore.getUser(userId);

    System.out.println();
    System.out.println("=====================");
    System.out.println("Stats for user : " + userId);
    System.out.println("=====================");

    System.out.println("Total trips taken : " + user.getTripsTaken().size());
    if(user.getTripsTaken().size()>0)
      System.out.println("Details of trip taken");
    for (Trip trip : user.getTripsTaken()) {
      System.out.println(trip);
    }

    System.out.println();
    System.out.println();

    System.out.println("Total trips offered : " + user.getTripsOffered().size());
    if(user.getTripsOffered().size()>0)
      System.out.println("Details of trip offered");
    for (Trip trip : user.getTripsOffered()) {
      System.out.println(trip);
    }
  }

  // can be moved to R
  private Trip getTrip(String passengerId, Ride ride) {
    Trip trip = new Trip();
    trip.setOrigin(ride.getOrigin());
    trip.setDestination(ride.getDestination());
    trip.setDriver(ride.getDriver());
    trip.setPassenger(passengerId);
    trip.setVehicleId(ride.getVehicleId());
    trip.setStartTime(ride.getStartTime());
    return trip;
  }

  public void addUser(User user) {
    Datastore.addUser(user);
  }

  public void addVehicle(Vehicle vehicle) {
    Datastore.addVehicles(vehicle);
  }

  public User getUser(String userId) {
    return Datastore.getUser(userId);
  }
}
