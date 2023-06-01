package MCexamples.MeetingSchduler.model;


import MCexamples.lowlevel.mine.MeetingSchduler.constants.TimeSlotDetails;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

/**
 * Created by abhishek.gupt on 27/12/17.
 */
public class TimeSlot {


    private Date beginDate;
    private Date endDate;

    public TimeSlot(Date beginDate, Date endDate) {
        this.beginDate = beginDate;
        this.endDate = endDate;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public boolean collidesWith(TimeSlot timeSlot) {

        if (timeSlot.beginDate.getTime() > beginDate.getTime()
                && timeSlot.beginDate.getTime() < endDate.getTime())
        {
            return true;
        }

        if (timeSlot.endDate.getTime() > beginDate.getTime()
                && timeSlot.endDate.getTime() < endDate.getTime())
        {
            return true;
        }
        return false;
    }

    public static TimeSlot createNewSlot(String beginDate, String endDate)
    {
        SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy hh:mm");
        try {
            return new TimeSlot(format.parse(beginDate), format.parse(endDate));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;

    }

//    public String toString()
//    {
//        return "Start : " + beginDate.toString() + ", End : " + endDate.toString();
//    }

    @Override
    public String toString() {
        TimeSlot timeSlot = this;
        HashMap<String, Object> data = new HashMap<>();
        data.put(TimeSlotDetails.START.getDetail(), timeSlot.getBeginDate());
        data.put(TimeSlotDetails.END.getDetail(), timeSlot.getEndDate());
        return data.toString();
    }

}
