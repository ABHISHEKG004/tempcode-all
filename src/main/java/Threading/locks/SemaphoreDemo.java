package Threading.locks;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphoreDemo {

    public static void main(String[] args) {

        Semaphore semaphore = new Semaphore(4);
        ExecutorService executor = Executors.newFixedThreadPool(9);

        Runnable task = () -> {
          boolean permit = false;
          try {
//              permit = semaphore.tryAcquire(1, TimeUnit.SECONDS);
//              permit = semaphore.tryAcquire(4, TimeUnit.SECONDS);
              permit = semaphore.tryAcquire(5, TimeUnit.SECONDS);
              if (permit){
                  System.out.println("acquired semaphore yay");
                  Thread.sleep(4000);
              } else {
                  System.out.println("not able to acquire semaphore");
              }
          } catch (InterruptedException e) {
              e.printStackTrace();
          } finally {
              if (permit){
                  semaphore.release();
              }
          }
        };

        for(int i = 0;i<9;i++){
            executor.submit(task);
        }

    }
}
