package MCexamples.inemoryQueueSystem.services;

import com.design.lowlevel.mine.inemoryQueueSystem.models.Message;
import com.design.lowlevel.mine.inemoryQueueSystem.subscriber.Subscriber;
import com.design.lowlevel.mine.inemoryQueueSystem.utils.MyQueue;
import com.design.lowlevel.mine.inemoryQueueSystem.utils.ObjectMapperUtil;

import java.io.IOException;
import java.util.*;

/**
 * Created by Abhishek gupta on 2019-08-30
 */


public class PubSubService {

  private Map<String, Set<Subscriber>> subscribersRegexMap = new HashMap<String, Set<Subscriber>>();

  private MyQueue myQueue = new MyQueue(100);

  private List<Subscriber> topologicalOrder;

  public PubSubService(List<Subscriber> topologicalOrder) {
    this.topologicalOrder = topologicalOrder;
  }

  public void addMessageToQueue(Message message) throws InterruptedException {
    myQueue.add(message);
  }

  public void addSubscriber(String regex, Subscriber subscriber){

    if(subscribersRegexMap.containsKey(regex)){
      Set<Subscriber> subscribers = subscribersRegexMap.get(regex);
      subscribers.add(subscriber);
      subscribersRegexMap.put(regex, subscribers);
    }else{
      Set<Subscriber> subscribers = new HashSet<Subscriber>();
      subscribers.add(subscriber);
      subscribersRegexMap.put(regex, subscribers);
    }
  }

  public void sendMessages() throws InterruptedException, IOException {

    if(myQueue.getCurrentSize()==0){
      System.out.println("No messages from producers");
    }else{

      while(myQueue.getCurrentSize() != 0){
        Message message = (Message)myQueue.remove();

        for ( String regex : subscribersRegexMap.keySet() ) {
          String mess = ObjectMapperUtil.objectMapperUtil.writeValueAsString(message);
          if(mess.contains(regex)){

            Set<Subscriber> subscribersOfRegex= subscribersRegexMap.get(regex);

            for(Subscriber subscriber : topologicalOrder){
              if(subscribersOfRegex.contains(subscriber)){
                subscriber.printMessages(message);
              }
            }
          }
        }
      }

    }
  }

}