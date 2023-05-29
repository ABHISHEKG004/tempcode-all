package MCexamples.inemoryQueueSystem.driver;


import com.design.lowlevel.mine.inemoryQueueSystem.models.Message;
import com.design.lowlevel.mine.inemoryQueueSystem.producer.Producer;
import com.design.lowlevel.mine.inemoryQueueSystem.producer.ProducerImpl;
import com.design.lowlevel.mine.inemoryQueueSystem.services.PubSubService;
import com.design.lowlevel.mine.inemoryQueueSystem.subscriber.Subscriber;
import com.design.lowlevel.mine.inemoryQueueSystem.subscriber.SubscriberImpl;
import com.design.lowlevel.mine.inemoryQueueSystem.utils.TopDependency;

import java.io.IOException;
import java.util.*;

/**
 * Created by Abhishek gupta on 2019-08-30
 */

public class DriverClass {
  public static void main(String[] args) throws InterruptedException, IOException {

    Subscriber subscriber1 = new SubscriberImpl("subscriber1");
    Subscriber subscriber2 = new SubscriberImpl("subscriber2");
    Subscriber subscriber3 = new SubscriberImpl("subscriber3");

    Map<Integer, Subscriber> subscriberIndexMap = new HashMap<>();
    subscriberIndexMap.put(0,subscriber1);
    subscriberIndexMap.put(1,subscriber2);
    subscriberIndexMap.put(2,subscriber3);

    TopDependency topDependency = new TopDependency(3);
//    2 is dependent on 0 and 1
//    subscriber3 is dependent on subscriber1 and subscriber2
    topDependency.addEdge(0, 2);
    topDependency.addEdge(1, 2);
    Stack st = topDependency.topologicalSort();

    List<Subscriber> topologicalOrder = new ArrayList<>();
    while (!st.empty()){
      Integer index = (Integer)st.pop();
//      System.out.println(index);
      topologicalOrder.add(subscriberIndexMap.get(index));
    }

    PubSubService pubSubService = new PubSubService(topologicalOrder);

//    Message msg1 = new Message("ab", "three","bc");
//    Message msg2 = new Message("two", "random", "mess");
//    Message msg3 = new Message("class", "super", "one");
    Message msg1 = new Message("ab", "three","bc");

    Producer producer = new ProducerImpl();
    producer.publish(msg1, pubSubService);
//    producer.publish(msg2, pubSubService);
//    producer.publish(msg3, pubSubService);

//    subscriber1.addSubscriber("\"two\":\"three\"", pubSubService);
//    subscriber2.addSubscriber("\"one\":\"class\"",pubSubService);
//    subscriber3.addSubscriber("\"one\":\"class\"",pubSubService);
    subscriber1.addSubscriber("\"two\":\"three\"", pubSubService);
    subscriber2.addSubscriber("\"two\":\"three\"",pubSubService);
    subscriber3.addSubscriber("\"two\":\"three\"",pubSubService);

    pubSubService.sendMessages();

  }
}