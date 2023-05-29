package MCothers.hotelbooking;//package Design.hotelbooking;
//
//import java.util.Date;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
///**
// * Created by gaurav.kum on 23/12/17.
// */
//public class Room {
//    Integer roomNo, floorNo;
//    Map<Date, Reservation> reservedDate;
//
//    Room(Integer roomNo) {
//        this.roomNo = roomNo;
//        reservedDate = new HashMap<>();
//    }
//
//    public Reservation bookRoomForDates(List<Date> dates, Guest guest) {
//        for(Date date: dates) {
//            if(reservedDate.get(date) != null) {
//                return null;
//            }
//        }
//
//        return new Reservation(this, dates.get(0), dates.get(dates.size()-1), guest);
//    }
//}
