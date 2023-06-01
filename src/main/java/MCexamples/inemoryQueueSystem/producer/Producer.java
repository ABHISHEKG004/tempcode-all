package MCexamples.inemoryQueueSystem.producer;

import MCexamples.lowlevel.mine.inemoryQueueSystem.models.Message;
import MCexamples.lowlevel.mine.inemoryQueueSystem.services.PubSubService;

/**
 * Created by Abhishek gupta on 2019-08-30
 */


public interface Producer {
  void publish(Message message, PubSubService pubSubService) throws InterruptedException;
}