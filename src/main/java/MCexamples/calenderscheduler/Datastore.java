package MCexamples.calenderscheduler;

import java.util.ArrayList;
import java.util.HashMap;

public class Datastore {

    //fields can be made private and get/updation/addditon through some methods in this class only


    private static HashMap<String, HashMap<String, ArrayList<Meeting>> > userMeetingsDayWise = new HashMap<>();
    //ex - user1, day1 - listofmeetings, user1, day2 - listofmeetings

    public static HashMap<String, Hierrachy> hierrachyHashMap = new HashMap<>();

    public static HashMap<String, HashMap<String, ArrayList<Meeting>> > getUserMeetingsDayWise(){
        return userMeetingsDayWise;
    }


}
