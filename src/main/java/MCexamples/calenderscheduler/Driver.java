package MCexamples.calenderscheduler;

import java.util.ArrayList;

public class Driver {

    public static void main(String[] args) {

        CalnderAssistantService calnderAssistantService = new CalnderAssistantService();

        calnderAssistantService.addHierarchy("Nitish", Hierrachy.MANAGER);
        calnderAssistantService.addHierarchy("Kumar", Hierrachy.COO);
        calnderAssistantService.addHierarchy("Iravati", Hierrachy.MANAGER);
        calnderAssistantService.addHierarchy("John", Hierrachy.DIRECTOR);
        calnderAssistantService.addHierarchy("Raju", Hierrachy.DIRECTOR);
        calnderAssistantService.addHierarchy("Self", Hierrachy.DIRECTOR);


        calnderAssistantService.addMeeting("Raju", "day1",
                new Meeting("Scrum", "10:15AM", "12:00PM", 7, "Self"));
        calnderAssistantService.addMeeting("Raju", "day1",
                new Meeting("OKR review", "03:00PM", "05:00PM", 4, "Kumar"));
        calnderAssistantService.addMeeting("Raju", "day1",
                new Meeting("design review", "05:00PM", "06:00PM", 6, "Iravati"));
        calnderAssistantService.addMeeting("Raju", "day1",
                new Meeting("design discussion", "11:45AM", "01:30PM", 6, "Nitish"));

        ArrayList<Meeting> input1 = Datastore.getUserMeetingsDayWise().get("Raju").get("day1");

        System.out.println(input1);


        //use case 1
        ArrayList<Resolver> resolvers = new ArrayList<>();
        resolvers.add(new OrganizerResolver(1));
        resolvers.add(new HierarchyResolver(2));
        resolvers.add(new AttendesResolver(0));
        resolvers.add(new RandomResolver(3));

        ArrayList<Meeting> output1 = calnderAssistantService.resolveConflicts("Raju", "day1", resolvers);

        System.out.println(output1);


        //use case 2
        ArrayList<Meeting> input2 = Datastore.getUserMeetingsDayWise().get("Raju").get("day1");

        int duration = 30; //in mins
        calnderAssistantService.recommendMeeting("Raju", "day1", duration);

//        System.out.println(output2);





    }

}
