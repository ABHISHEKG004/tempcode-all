package MCexamples.asyncLogger.utils;

import MCexamples.asyncLogger.enums.LogLevel;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Abhishek gupta on 2019-05-04
 */
//
public class Formatter {

  private static DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

  public static String simpleFormatter(LogLevel level, String msg){
    Date date = new Date();
    return "[" + dateFormat.format(date) + "] " + level + " : " + msg;
  }

}
