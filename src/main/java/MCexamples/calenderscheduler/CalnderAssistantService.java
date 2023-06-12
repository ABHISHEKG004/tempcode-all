package MCexamples.calenderscheduler;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class CalnderAssistantService {

    public ArrayList<Meeting> resolveConflicts(String user, String day, ArrayList<Resolver> resolvers){

        ArrayList<Meeting> inp = getUserData(user, day); //sorted by endtime
        if(inp==null){
            System.out.println("user data doesn't exist");
            return null;
        }

        //array sort can also be done
        PriorityQueue<Resolver> pq = new
                PriorityQueue<Resolver>( new ResolverComparator());

        //            inp = resolvers.get(i).resolve(inp);
        pq.addAll(resolvers);

        while (!pq.isEmpty()) {
            inp = pq.poll().resolve(inp);
        }

        for(int i = 0; i<resolvers.size(); i++){

            pq.add(resolvers.get(i));
            inp = resolvers.get(i).resolve(inp);

        }


        Datastore.getUserMeetingsDayWise().get(user).put(day, inp);
        //update datastroe user, day map also

        return inp;
    }

    public void recommendMeeting(String user, String day, int duration){
        ArrayList<Meeting> inp = getUserData(user, day); //sorted by endtime

        if(inp==null){
            System.out.println("user data doesn't exist");
            return;
        }


//        ArrayList<Meeting> recomended = new ArrayList<>(inp);
        inp.sort(new MeetingComparator2()); //sort by start time

        int k = inp.size();

        int i = 0;

        while(i+1<k){

            if(inp.get(i+1).getStartTime() >= inp.get(i).getEndTime() + duration){
                System.out.println("recommed after meeting " +  inp.get(i).getName());
                return;
            }

            if(inp.get(i+1).getName().equals("FOCUS") && inp.get(i+1).getStartTime() > inp.get(i).getEndTime()){
                System.out.println("FOCUS recommed after meeting " +  inp.get(i).getName());
                return;
            }

            i++;

        }
        System.out.println("sorry not able to found recommed time");
        return;
    }

    public void addMeeting(String user, String day, Meeting meeting){

        try {
            validateMeeting(meeting);

            meeting.setStartTime(Utils.convertToDayMinutes(meeting.getStart()));
            meeting.setEndTime(Utils.convertToDayMinutes(meeting.getEnd()));

//            HashMap<String, HashMap<String, ArrayList<Meeting>>> userMeetings = Datastore.getUserMeetingsDayWise();

            if (!Datastore.getUserMeetingsDayWise().containsKey(user)) {
                Datastore.getUserMeetingsDayWise().put(user, new HashMap<String, ArrayList<Meeting>>());
            }

            if (!Datastore.getUserMeetingsDayWise().get(user).containsKey(day)) {
                Datastore.getUserMeetingsDayWise().get(user).put(day, new ArrayList<>());
            }

            Datastore.getUserMeetingsDayWise().get(user).get(day).add(meeting);



            System.out.println("Meeting succsfully added");
        } catch (Exception e) {

            System.out.println("Can't add meeting due to : " + e.getMessage());
        }

    }

    public void addHierarchy(String user, Hierrachy hierrachy){
        Datastore.hierrachyHashMap.put(user, hierrachy);
    }

    private void validateMeeting(Meeting meeting) throws InvalidMeetingException {

        if(!Utils.validateTimeFormat(meeting.getStart())){
            throw new InvalidMeetingException("start time format wrong");
        }

        if(!Utils.validateTimeFormat(meeting.getEnd())){
            throw new InvalidMeetingException("end time format wrong");
        }

        if(!Utils.validateStartEndTime(meeting.getStart(), meeting.getEnd())){
            throw new InvalidMeetingException("start time is not less than end time");
        }

    }


    private ArrayList<Meeting> getUserData(String user, String day){
        ArrayList<Meeting> inp = null;
        if(Datastore.getUserMeetingsDayWise().get(user)!=null && Datastore.getUserMeetingsDayWise().get(user).get(day)!=null){
            inp = Datastore.getUserMeetingsDayWise().get(user).get(day);
        }

        if(inp!=null){
            inp.sort(new MeetingComparator());
        }
        return inp;
    }
}


class ResolverComparator implements Comparator<Resolver> {

    // Overriding compare()method of Comparator
    // for ascending order of priority
    public int compare(Resolver s1, Resolver s2) {
        if (s1.getPriority() < s2.getPriority())
            return -1;
        else if (s1.getPriority() > s2.getPriority())
            return 1;
        return 0;
    }
}


class MeetingComparator implements Comparator<Meeting> {

    // Overriding compare()method of Comparator
    // for ascending order of endtime
    public int compare(Meeting s1, Meeting s2) {
        if (s1.getEndTime() < s2.getEndTime())
            return -1;
        else if (s1.getEndTime() > s2.getEndTime())
            return 1;
        return 0;
    }
}


class MeetingComparator2 implements Comparator<Meeting> {

    // Overriding compare()method of Comparator
    // for ascending order of startime
    public int compare(Meeting s1, Meeting s2) {
        if (s1.getStartTime() < s2.getStartTime())
            return -1;
        else if (s1.getStartTime() > s2.getStartTime())
            return 1;
        return 0;
    }
}