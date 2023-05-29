package MCothers.parkinglot;

/**
 * Created by gaurav.kum on 02/12/17.
 */
public class Car extends Vehicle {

    public Car(String namePlate) {
        super(namePlate);
        spotsNeeded = 2;
        vehicleType = VehicleType.MEDIUM;
    }

    @Override
    public boolean canFitInSmallSpot() {
        return false;
    }

    @Override
    public boolean canFitInMediumSpot() {
        return true;
    }

    @Override
    public boolean canFitInLargeSpot() {
        return true;
    }
}
