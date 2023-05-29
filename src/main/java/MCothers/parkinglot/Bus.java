package MCothers.parkinglot;

/**
 * Created by gaurav.kum on 02/12/17.
 */
public class Bus extends Vehicle {
    public Bus(String namePlate) {
        super(namePlate);
        spotsNeeded = 4;
        vehicleType = VehicleType.LARGE;
    }

    @Override
    public boolean canFitInSmallSpot() {
        return false;
    }

    @Override
    public boolean canFitInMediumSpot() {
        return false;
    }

    @Override
    public boolean canFitInLargeSpot() {
        return true;
    }
}
