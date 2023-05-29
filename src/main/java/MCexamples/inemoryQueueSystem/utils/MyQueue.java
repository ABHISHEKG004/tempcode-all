package MCexamples.inemoryQueueSystem.utils;

import lombok.Getter;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Abhishek gupta on 2019-08-30
 */


@Getter
public class MyQueue {

  private List queue = new LinkedList();
  private int  maxSize;
  private int currentSize;

  public MyQueue(int maxSize){
    this.maxSize = maxSize;
    this.currentSize = 0;
  }


  public synchronized void add(Object item) throws InterruptedException {
    while(this.queue.size() == this.maxSize) {
      wait();
    }
    if(this.queue.isEmpty()) {
      notifyAll();
    }
    this.queue.add(item);
    currentSize++;
  }


  public synchronized Object remove()
      throws InterruptedException{
    while(this.queue.isEmpty()){
      wait();
    }
    if(this.queue.size() == this.maxSize){
      notifyAll();
    }
    currentSize--;
    return this.queue.remove(0);
  }

}