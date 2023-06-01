package MCexamples.asyncLogger.services;

import MCexamples.asyncLogger.enums.LogLevel;
import MCexamples.asyncLogger.services.appenders.Appender;

import java.util.ArrayList;

public class Logger {

  // Appenders is property of logger because we may want to have or customize Logger according to
  // our needs . for ex - I want to have only consoleAppender in my logger
  // we can also have other property of logger as well like its name
  private ArrayList<Appender> appenders;

  public Logger(ArrayList<Appender> appenders) {
    this.appenders = appenders;
  }

  public void init() {

    for (Appender appender : appenders) {
      new Thread(new LogConsumer(appender)).start();
    }
  }

  private void log(LogLevel logLevel, String message) {
    for (Appender appender : appenders) {
      try {
        //can also create separate private producer method (appending is ~= producing)
        // in this class itself instead of creating Appender as abstract and defining
        // that method there
        appender.appendToQueue(logLevel, message);
      } catch (Exception e) {
        System.out.println("Exception : " + e);
      }
    }
  }

  public void info(String msg) {
    this.log(LogLevel.INFO, msg);
  }

  public void error(String msg) {
    this.log(LogLevel.ERROR, msg);
  }

  public void debug(String msg) {
    this.log(LogLevel.DEBUG, msg);
  }
}
