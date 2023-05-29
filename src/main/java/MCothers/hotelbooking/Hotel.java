package MCothers.hotelbooking;//package Design.hotelbooking;
//
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
///**
// * Created by gaurav.kum on 23/12/17.
// */
//public class Hotel {
//    String name, address;
//    List<Room> rooms;
//
//    Hotel(String name, String address) {
//        this.name = name;
//        this.address = address;
//        rooms = new ArrayList<>();
//    }
//
//    public Reservation bookRoom(List<Date> dates, Guest guest) {
//        for(Room room: rooms) {
//            Reservation reservation = room.bookRoomForDates(dates, guest);
//
//            if(reservation != null) {
//                return reservation;
//            }
//        }
//
//        return null;
//    }
//
//}
