package MCexamples.inemoryQueueSystem.subscriber;

import MCexamples.lowlevel.mine.inemoryQueueSystem.models.Message;
import MCexamples.lowlevel.mine.inemoryQueueSystem.services.PubSubService;

/**
 * Created by Abhishek gupta on 2019-08-30
 */


public abstract class Subscriber {

  public abstract void printMessages(Message message);

  public void addSubscriber(String regex, PubSubService pubSubService){
    pubSubService.addSubscriber(regex, this);
  }
}
