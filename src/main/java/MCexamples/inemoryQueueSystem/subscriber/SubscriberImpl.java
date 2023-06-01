package MCexamples.inemoryQueueSystem.subscriber;

import MCexamples.lowlevel.mine.inemoryQueueSystem.models.Message;

/**
 * Created by Abhishek gupta on 2019-08-30
 */


public class SubscriberImpl extends Subscriber{

  private String name;
  public SubscriberImpl(String name) {
    this.name = name;
  }

  public void printMessages(Message message) {
    System.out.println(name + " : " + message.toString());
  }
}