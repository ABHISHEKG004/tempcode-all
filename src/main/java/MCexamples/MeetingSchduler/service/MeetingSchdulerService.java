package MCexamples.MeetingSchduler.service;


import com.design.lowlevel.mine.MeetingSchduler.datastore.DataStore;
import com.design.lowlevel.mine.MeetingSchduler.model.Meeting;
import com.design.lowlevel.mine.MeetingSchduler.model.TimeSlot;

/**
 * Created by abhishek.gupt on 27/12/17.
 */
public class MeetingSchdulerService {

    public void printAllMeetings() {

        for(TimeSlot slot : DataStore.getAllMeetings().keySet())
        {
            System.out.println(slot  + " -> " +  DataStore.getAllMeetings().get(slot));
        }
    }



    public void addMeetings() {

        System.out.println("Succesfully Added : " + DataStore.addMeeting(new Meeting("First meeting"),
                TimeSlot.createNewSlot("03/01/2013 08:00", "03/01/2013 08:30")));
        System.out.println("Succesfully Added : " + DataStore.addMeeting(new Meeting("Second meeting"),
                TimeSlot.createNewSlot("03/01/2013 08:30", "03/01/2013 09:15")));
        System.out.println("Succesfully Added : " + DataStore.addMeeting(new Meeting("Third meeting"),
                TimeSlot.createNewSlot("03/01/2013 07:30", "03/01/2013 08:15")));
        System.out.println("Succesfully Added : " + DataStore.addMeeting(new Meeting("Fourth meeting"),
                TimeSlot.createNewSlot("03/01/2013 09:15", "03/01/2013 09:45")));

    }
}
