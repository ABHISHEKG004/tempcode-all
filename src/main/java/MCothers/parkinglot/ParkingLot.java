package MCothers.parkinglot;

import java.util.*;

/**
 * Created by gaurav.kum on 02/12/17.
 */
public class ParkingLot {
    private static final int NO_SMALL_SPOTS = 100;
    private static final int NO_MEDIUM_SPOTS = 50;
    private static final int NO_LARGE_SPOTS = 25;

    private List<ParkingSpot> smallSpots;
    private List<ParkingSpot> mediumSpots;
    private List<ParkingSpot> largeSpots;
    private Map<Long, ParkingSpot> occupiedSpots;

    public ParkingLot() {
        smallSpots = new ArrayList<>(NO_SMALL_SPOTS);
        mediumSpots = new ArrayList<>(NO_MEDIUM_SPOTS);
        largeSpots = new ArrayList<>(NO_LARGE_SPOTS);
        createSlots();
        occupiedSpots = new HashMap<>();
    }

    private void createSlots() {
        for (int i = 1; i <= NO_SMALL_SPOTS; i++) {
            smallSpots.add(new SmallSpot(i));
        }
        for (int i = 1; i <= NO_MEDIUM_SPOTS; i++) {
            mediumSpots.add(new MediumSpot(i));
        }
        for (int i = 1; i <= NO_LARGE_SPOTS; i++) {
            largeSpots.add(new LargeSpot(i));
        }
    }

    public long park(Vehicle vehicle) {
        ParkingSpot spot;
        long uniqueToken = -1;

        if (vehicle.canFitInSmallSpot()) {
            if ((spot = getFirstEmptySlot(smallSpots)) != null) {
                uniqueToken = parkHelper(spot, vehicle);
            }
        }
        if (vehicle.canFitInMediumSpot()) {
            if ((spot = getFirstEmptySlot(mediumSpots)) != null) {
                uniqueToken = parkHelper(spot, vehicle);
            }
        }
        if(vehicle.canFitInLargeSpot()) {
            if ((spot = getFirstEmptySlot(largeSpots)) != null) {
                uniqueToken = parkHelper(spot, vehicle);
            }
        }
        return uniqueToken;
    }

    public void unPark(long uniqueToken) {
        occupiedSpots.get(uniqueToken).unpark();
        occupiedSpots.remove(uniqueToken);
    }

    private ParkingSpot getFirstEmptySlot(List<ParkingSpot> slots) {
        Iterator<ParkingSpot> slotIterator = slots.iterator();
        boolean isSlotFound = false;
        ParkingSpot emptySlot = null;

        while (slotIterator.hasNext() && !isSlotFound) {
            emptySlot = slotIterator.next();
            if (!emptySlot.isOccupied()) {
                isSlotFound = true;
            }
        }
        return emptySlot;
    }

    private long parkHelper(ParkingSpot slot, Vehicle vehicle) {
        slot.park();
        long uniqueToken = slot.hashCode() * 43;
        occupiedSpots.put(uniqueToken, slot);
        return uniqueToken;
    }

}
