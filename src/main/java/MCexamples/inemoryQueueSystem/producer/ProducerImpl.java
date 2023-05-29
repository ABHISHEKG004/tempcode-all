package MCexamples.inemoryQueueSystem.producer;

import com.design.lowlevel.mine.inemoryQueueSystem.models.Message;
import com.design.lowlevel.mine.inemoryQueueSystem.services.PubSubService;

/**
 * Created by Abhishek gupta on 2019-08-30
 */


public class ProducerImpl implements Producer {
  public void publish(Message message, PubSubService pubSubService) throws InterruptedException {
    pubSubService.addMessageToQueue(message);
  }
}