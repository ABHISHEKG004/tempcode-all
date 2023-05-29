package Threading.locks;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockDemo {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        ReadWriteLock lock = new ReentrantReadWriteLock();

        ExecutorService executor = Executors.newFixedThreadPool(2);

        Runnable writetask = () -> {
          lock.writeLock().lock();

          try {
              list.add("item1");
              System.out.println("write task : item added");
              Thread.sleep(2000);
          } catch (InterruptedException e) {
              e.printStackTrace();
          } finally {
              lock.writeLock().unlock();
          }

        };

        Runnable readtask = () -> {
            lock.readLock().lock();

            try {
                System.out.println("read task : " + list.get(0));
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.readLock().unlock();
            }

        };

        executor.submit(writetask);
        executor.submit(readtask);
        executor.submit(readtask);
    }
}
