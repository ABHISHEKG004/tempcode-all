package MCothers.parkinglot;

/**
 * Created by gaurav.kum on 02/12/17.
 */
public abstract class Vehicle {
    protected String numberPlate;
    protected VehicleType vehicleType;
    protected int spotsNeeded;

    public Vehicle(String numberPlate) {
        this.numberPlate = numberPlate;
    }

    public int getSpotsNeeded() {
        return spotsNeeded;
    }

    public void setSpotsNeeded(int spotsNeeded) {
        this.spotsNeeded = spotsNeeded;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getNumberPlate() {
        return numberPlate;
    }

    public void setNumberPlate(String numberPlate) {
        this.numberPlate = numberPlate;
    }

    public abstract boolean canFitInSmallSpot();

    public abstract boolean canFitInMediumSpot();

    public abstract boolean canFitInLargeSpot();
}
