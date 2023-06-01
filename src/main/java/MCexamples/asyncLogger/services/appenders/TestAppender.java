package MCexamples.asyncLogger.services.appenders;

import MCexamples.asyncLogger.enums.LogLevel;

import java.util.Queue;

/**
 * Created by Abhishek gupta on 2019-05-04
 */

public class TestAppender extends Appender {

  public TestAppender(Queue<String> logQueue, int maxQueueSize, LogLevel logLevel) {
    super(logQueue, maxQueueSize, logLevel);
  }

  @Override
  public void write(String message) {
    System.out.println("TestAppender " + message);
  }
}
