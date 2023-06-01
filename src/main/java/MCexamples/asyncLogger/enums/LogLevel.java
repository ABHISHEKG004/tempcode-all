package MCexamples.asyncLogger.enums;

/**
 * Created by Abhishek gupta on 2019-05-04
 */

public enum LogLevel
{

  ALL (1), DEBUG(2), INFO(3), ERROR(4);

  private int value;

  public int getValue()
  {
    return this.value;
  }

  private LogLevel(int value)
  {
    this.value = value;
  }
}