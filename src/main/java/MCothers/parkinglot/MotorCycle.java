package MCothers.parkinglot;

/**
 * Created by gaurav.kum on 02/12/17.
 */
public class MotorCycle extends Vehicle {

    public MotorCycle(String namePlate) {
        super(namePlate);
        spotsNeeded = 1;
        vehicleType = VehicleType.SMALL;
    }

    @Override
    public boolean canFitInSmallSpot() {
        return true;
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
