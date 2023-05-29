package MCexamples.ridesharing;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by Abhishek gupta on 2019-09-21
 */

public class Utils {

  public static Date addHoursToJavaUtilDate(Date date, int hours) {
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(date);
    calendar.add(Calendar.HOUR_OF_DAY, hours);
    return calendar.getTime();
  }

}
