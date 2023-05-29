package Threading.locks;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.StampedLock;

public class StampedLockDemo {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        StampedLock lock = new StampedLock();

        ExecutorService executor = Executors.newFixedThreadPool(2);

        Runnable writetask = () -> {
            long stamp = lock.writeLock();

            try {
                list.add("item1");
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlockWrite(stamp);
            }

        };

        Runnable readtask = () -> {
            long stamp = lock.readLock();

            try {
                System.out.println(list.get(0));
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlockRead(stamp);
            }

        };

        executor.submit(writetask);
        executor.submit(readtask);
        executor.submit(readtask);
    }
}
