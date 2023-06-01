package MCexamples.MeetingSchduler.driver;

import MCexamples.lowlevel.mine.MeetingSchduler.service.MeetingSchdulerService;

/**
 * Created by abhishek.gupt on 27/12/17.
 */
public class Driver {

    public static void main(String[] args)
    {
        MeetingSchdulerService scheduler = new MeetingSchdulerService();
        scheduler.addMeetings();
        scheduler.printAllMeetings();
    }

}
