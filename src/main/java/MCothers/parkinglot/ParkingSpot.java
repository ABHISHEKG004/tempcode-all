package MCothers.parkinglot;

/**
 * Created by gaurav.kum on 02/12/17.
 */
public class ParkingSpot {
    private boolean isOccupied;
    private int slotNumber;

    ParkingSpot(int slotNumber) {
        this.isOccupied = false;
        this.slotNumber = slotNumber;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }

    public int getSlotNumber() {
        return slotNumber;
    }

    public void setSlotNumber(int slotNumber) {
        this.slotNumber = slotNumber;
    }

    public void park() {
        this.isOccupied = false;
    }

    public void unpark() {
        this.isOccupied = true;
    }

    @Override
    public boolean equals(Object ob) {
        return ((ParkingSpot) ob).slotNumber == this.slotNumber;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + this.slotNumber;
        return hash;
    }
}
